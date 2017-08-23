package com.vivek

import grails.transaction.Transactional
import groovy.util.logging.Log4j
import org.springframework.http.HttpStatus

import static com.vivek.util.CodingUtil.getResponseBody

@Transactional
@Log4j
class PhoneService {

    def messageSource
    Map<String, Object> body

    def activate(Map params) {
        log.debug("In Service, Activate phone")
        if (!params.number) {
            log.error("In Service, Phone number not coming from params")
            body = getResponseBody(null, HttpStatus.BAD_REQUEST, messageSource.getMessage("validation.failed", null, Locale.default), null)
        } else {
            log.debug("In Service, Phone number exist")
            Phone phone = Phone.findByNumber(params.number as long)
            if (!phone) {
                log.error("In Service, Phone number doesn't exist in database")
                List validationError = ["Number not found in list"]
                body = getResponseBody(null, HttpStatus.NOT_FOUND, messageSource.getMessage("validation.failed", null, Locale.default), validationError)
            } else {
                log.debug("In Service, Phone exist in db. Trying to save it.")
                phone.isActivate = true
                try {
                    phone.save()
                    body = getResponseBody(phone, HttpStatus.OK, messageSource.getMessage("validation.succeeded", null, Locale.default), null)
                    log.info("Phone number $phone activated")
                } catch (Exception ex) {
                    log.error("Unable to save Phone. Exception: " + ex.message)
                    List<String> validationError = ["Something went wrong. Please contact to Administrator"]
                    body = getResponseBody(null, HttpStatus.INTERNAL_SERVER_ERROR, messageSource.getMessage("validation.failed", null, Locale.default), validationError)
                }
            }
        }
        return body
    }

    def getPhoneList(Map params) {
        log.debug("In Service, get phone list.")
        if (params.customerId && !params.customerId.isNumber()) {
            log.error("Wrong data coming in request. Params are $params")
            List error = ["Please provide correct customer id"]
            body = getResponseBody(null, HttpStatus.BAD_REQUEST, messageSource.getMessage("validation.failed", null, Locale.default), error)
        } else {
            log.debug("Trying to get phone list from database.")
            List<Phone> phoneList = Phone.createCriteria().list() {
                if (params.customerId) {
                    eq('customer.id', params.customerId as long)
                }
            }
            log.info("Trying to get phone list from database.  phone List are: $phoneList")
            body = getResponseBody(phoneList.toArray(), HttpStatus.OK, messageSource.getMessage("validation.succeeded", null, Locale.default), null)
        }
        return body
    }
}
