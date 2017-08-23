package com.vivek

import com.vivek.co.ShortenUrlCO
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.transaction.Transactional
import groovy.json.JsonSlurper
import groovy.util.logging.Log4j
import org.springframework.http.HttpStatus

@Transactional
@Log4j
class ShortenService {

    def grailsApplication
    def springSecurityService

    def shortURL(String urlToShort) {

        log.debug("Url to short:  $urlToShort")
        Map map = getUrlFromDB(urlToShort, false)
        log.info("Coming data from database is: " + map)
        if (map.isEmpty()) {
            log.info("Url not exist in database")
            RestBuilder builder = RestAPIBuilder.getInstance().getBuilder()
            RestResponse response = builder.post(grailsApplication.config.grails.google.api.url + "?key={key}") {
                urlVariables([key: grailsApplication.config.grails.google.api.key])
                contentType("application/json")
                json {
                    longUrl = urlToShort
                }
            }
            log.info("Info coming from API  " + response.properties)
            if (response.status == HttpStatus.OK.value()) {
                log.debug("response.body  " + response.body)
                storeUrlInDB(response.body)
                map = addSuccessResultInMap(response)
                log.info("Url saved in db successfully.")

            } else {
                log.error("Unable to get correct result from google API. Response body is: ${response.body} and status is: ${HttpStatus.valueOf(response.status)}")
                map = addFailResultInMap(response)
            }
        }
        return map
    }

    def expandURL(String urlToExtend) {

        log.debug("Url to short:  $urlToExtend")
        Map map = getUrlFromDB(urlToExtend, true)
        log.info("Coming data from database is: " + map)
        if (map.isEmpty()) {
            log.info("Url not exist in database")
            RestBuilder builder = RestAPIBuilder.getInstance().getBuilder()
            RestResponse response = builder.get(grailsApplication.config.grails.google.api.url + "?key={key}&shortUrl={shortUrl}") {
                urlVariables([key: grailsApplication.config.grails.google.api.key, shortUrl: urlToExtend])
                contentType("application/json")
            }

            log.info("Info coming from API  " + response.properties)

            if (response.status == HttpStatus.OK.value()) {
                log.debug("response.body  " + response.body)
                storeUrlInDB(response.body)
                map = addSuccessResultInMap(response)
                log.info("Url saved in db successfully.")

            } else {
                log.error("Unable to get correct result from google API. Response body is: ${response.body} and status is: ${HttpStatus.valueOf(response.status)}")
                map = addFailResultInMap(response)
            }
        }
        return map
    }

    def changeUrl(ShortenUrlCO shortenUrlCO) {
        log.debug("In Shorten Service Change Url")
        Map result
        switch (shortenUrlCO.urlType) {
            case UrlType.LONG:
                log.debug("Going to short URL")
                result = shortURL(shortenUrlCO.url)
                break
            case UrlType.SHORT:
                log.debug("Going to expand URL")
                result = expandURL(shortenUrlCO.url)
                break
            default:
                log.error("Please provide correct URL")
                result = [error: "Please provide correct url Type", status: 1000]
                break
        }
        return result
    }

    @Transactional
    private Map<String, String> getUrlFromDB(String url, boolean isShortUrl) {
        log.debug("In CHorten Service getUrlFromDB")
        User user = springSecurityService.currentUser as User
        log.debug("current user is:  $user  url is: $url")
        url = removeTrailSlash(url)
        Map map = [:]
        ShortenURL shortenURL = ShortenURL.createCriteria().get {
            eq('user', user)
            isShortUrl ? eq('shortUrl', url) : eq("longUrl", url)
        }

        log.info("shortenURL  ${shortenURL} for url $url  and isShortUrl is: $isShortUrl")
        if (shortenURL) {
            map = [shortUrl: shortenURL.shortUrl, longUrl: shortenURL.longUrl, status: HttpStatus.OK.value()]
        }
        log.info("Returning values from DB is: " + map)
        return map
    }

    private Map addSuccessResultInMap(RestResponse response) {
        def jsonSlurper = new JsonSlurper()
        Map body = (Map) jsonSlurper.parseText(response.body)
        return [shortUrl: body.id, longUrl: body.longUrl, status: response.status]
    }

    private Map addFailResultInMap(RestResponse response) {
        def jsonSlurper = new JsonSlurper()
        Map body = (Map) jsonSlurper.parseText(response.body)
        return [status: response.status, message: body.error.message]
    }

    @Transactional
    private ShortenURL storeUrlInDB(String body) {
        log.debug("In Shorten Service storeUrlInDB")
        def jsonSlurper = new JsonSlurper()
        Map response = (Map) jsonSlurper.parseText(body)
        User user = springSecurityService.currentUser as User
        ShortenURL shortenURL = new ShortenURL(longUrl: removeTrailSlash(response.longUrl), shortUrl: removeTrailSlash(response.id), user: user).save()
        log.info("Url stored successfully")
        return shortenURL
    }

    private String removeTrailSlash(String url) {
        if (url.endsWith("/")) {
            url = url.replaceAll("/*\$", "")
        }
        return url
    }
}
