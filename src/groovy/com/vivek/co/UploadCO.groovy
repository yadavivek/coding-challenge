package com.vivek.co

import grails.validation.Validateable

/**
 * Created by vivek on 21/8/17.
 */
@Validateable
class UploadCO {

    String usernameId
    int coin
    String username

    static constraints = {
        usernameId nullable: false, blank: false, matches: "^\\d{10}\$"
        coin nullable: false, validator: { value, object, errors ->
            if (value < 1 || value > Integer.MAX_VALUE) {
                errors.rejectValue("coin", "size.error")
            }
        }
        username nullable: false, blank: false
    }
}
