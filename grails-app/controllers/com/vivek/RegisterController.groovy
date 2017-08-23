package com.vivek

import com.vivek.co.UserCO

class RegisterController {

    def registerService

    def index() {}

    def save(UserCO userCO) {
        if (!userCO.validate()) {
            render(view: "index", model: [userCO: userCO])
            return
        }
        try {
            registerService.saveUser(userCO)
        } catch (Exception ex) {
            flash.message = ex.message
            render(view: "index")
            return
        }
        redirect(controller: 'shorten')
    }
}
