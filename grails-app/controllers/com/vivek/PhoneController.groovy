package com.vivek

import grails.converters.JSON
import grails.rest.RestfulController

class PhoneController extends RestfulController<Phone> {
    def phoneService

    def index() {
        log.debug("In Phone Controller with params:  $params")
        respond Phone.list(params), model: [bookCount: Phone.count()]
        Map<String, Object> responseBody = phoneService.getPhoneList(params)
        render contentType: 'application/json', text: responseBody as JSON
    }

    def activate() {
        log.debug("In Phone controller Activate phone")
        try {
            Map<String, Object> responseBody = phoneService.activate(params)
            render contentType: 'application/json', text: responseBody as JSON
        } catch (Exception ex) {
            log.error("Something went wrong while activating phone")
            String error = ex.message
            render contentType: 'application/json', text: error as JSON
        }
    }
}