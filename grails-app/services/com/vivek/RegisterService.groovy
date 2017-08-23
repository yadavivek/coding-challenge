package com.vivek

import com.vivek.co.UserCO
import grails.transaction.Transactional
import groovy.util.logging.Log4j

@Transactional
@Log4j
class RegisterService {

    def messageSource

    def saveUser(UserCO userCO) {
        log.debug("In Phone Service, userCO is: " + userCO)
        User user = new User(userCO.properties)
        try {
            log.debug("Trying to save users")
            user = user.save(failOnError: true)
            new UserRole(user: user, role: Role.findByAuthority(RoleEnum.ROLE_USER.name())).save()
            log.info("User $user saved successfully.")
        } catch (Exception ex) {
            log.error("Exception while trying to save user  ex: " + ex.message)
            StringBuilder builder = new StringBuilder()
            user.errors.each {
                builder.append(messageSource.getMessage("user.${it.fieldError.field}.${it.fieldError.code}", null, Locale.default))
            }
            log.error("All error messages are: " + builder.toString())
            throw new Exception(builder.toString())
        }
        return user
    }
}
