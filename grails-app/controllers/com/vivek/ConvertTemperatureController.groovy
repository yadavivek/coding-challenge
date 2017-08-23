package com.vivek

import com.vivek.co.ConvertTempCO
import com.vivek.exception.CodingException

class ConvertTemperatureController {

    def convertTemperatureService

    def index() {}

    def convert(ConvertTempCO convertTempCO) {
        log.info("In COnvert Temp CO $convertTempCO")
        try {
            double result = convertTemperatureService.convertTemperature(convertTempCO)
            render(template: '../convertTemperature/template/convert', model: [result: result])
        } catch (CodingException ce) {
            def errors = ce.message[1..ce.message.length() - 2].tokenize(",")
            render(template: '../convertTemperature/template/convert', model: [errors: errors])
        }
    }
}
