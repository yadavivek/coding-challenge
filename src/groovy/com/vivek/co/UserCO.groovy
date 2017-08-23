package com.vivek.co

import grails.validation.Validateable

/**
 * Created by vivek on 19/8/17.
 */
@Validateable
class UserCO {

    String username;
    String password
    String confirmPassword

    static constraints = {
        username nullable: false
        password nullable: false
        confirmPassword nullable: false, validator: { value, object, errors ->
            if (!value.equals(object.password)) {
                errors.rejectValue("password", "password.missmatch", "Password doesn't match to Confirm Password")
            }

        }
    }
}
