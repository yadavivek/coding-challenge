package com.vivek

import com.vivek.co.ConvertTempCO
import com.vivek.exception.CodingException
import grails.transaction.Transactional
import groovy.util.logging.Log4j

import javax.xml.ws.WebServiceException

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
        double result
        try {
            result = convertTemperature.getConvertTemperatureSoap().convertTemp(convertTempCO.temperature, TemperatureUnit.fromValue(convertTempCO.fromUnit.value), TemperatureUnit.fromValue(convertTempCO.toUnit.value));
            log.info("Result from Soap API $result")
            return result
        } catch (Exception ex) {
            log.error("Unable to hit on wsdl. ex: $ex.message")
            throw new CodingException([messageSource.getMessage("something.went.wrong", null, Locale.default)].toString())
        }
    }
}
