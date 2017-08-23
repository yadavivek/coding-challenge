package com.vivek

import com.vivek.co.ShortenUrlCO
import org.springframework.http.HttpStatus

class ShortenController {

    def shortenService

    def index() {}

    def save(ShortenUrlCO shortenUrlCO) {
        Map map = [:]
        if (shortenUrlCO.validate()) {
            Map result = shortenService.changeUrl(shortenUrlCO)
            if (result.status == HttpStatus.OK.value()) {
                render(template: '/template/sendUrl', model: result)
            } else {
                render(template: '/template/error', model: result)
            }
        } else {
            map = [message: "Please provide url"]
            render(template: '/template/error', model: map + [shortenUrlCO: shortenUrlCO])
        }
    }
}