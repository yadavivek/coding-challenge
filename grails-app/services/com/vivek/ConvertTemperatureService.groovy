package com.vivek

import com.vivek.co.ConvertTempCO
import com.vivek.exception.CodingException
import grails.transaction.Transactional
import groovy.util.logging.Log4j

@Transactional
@Log4j
class ConvertTemperatureService {

    def messageSource

    def convertTemperature(ConvertTempCO convertTempCO) {
        log.info("In ConvertTemperatureService convertTemperature")

        if (!convertTempCO.validate()) {
            List<String> validationErrors = []
            convertTempCO.errors.each {
                validationErrors.add(messageSource.getMessage("convertTempCO.${it.fieldError.field}.${it.fieldError.code}", null, Locale.default))
                throw new CodingException(validationErrors.toString())
            }
        }
        ConvertTemperature convertTemperature = new ConvertTemperature()
        log.info("convertTempCO.fromUnit.value  " + convertTempCO.fromUnit.value)
        log.info("convertTempCO.fromUnit.value  " + convertTempCO.fromUnit.value.getClass())
        log.info("convertTempCO.fromUnit.value with string  " + TemperatureUnit.fromValue("degreeCelsius"))
        log.info("convertTempCO.fromUnit.value  " + TemperatureUnit.fromValue(convertTempCO.fromUnit.value))
        double result = convertTemperature.getConvertTemperatureSoap().convertTemp(convertTempCO.temperature, TemperatureUnit.fromValue(convertTempCO.fromUnit.value), TemperatureUnit.fromValue(convertTempCO.toUnit.value));
        log.info("Result from Soap API $result")
        return result
    }
}
