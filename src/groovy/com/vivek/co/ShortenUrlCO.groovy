package com.vivek.co

import com.vivek.UrlType
import grails.validation.Validateable

/**
 * Created by vivek on 19/8/17.
 */
@Validateable
class ShortenUrlCO {

    String url
    UrlType urlType

    static constraints = {
        url url: true
        urlType nullable: false
    }
}
