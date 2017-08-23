package com.vivek.co

import com.vivek.TemperatureUnitType
import grails.validation.Validateable

/**
 * Created by vivek on 22/8/17.
 */
@Validateable
class ConvertTempCO {

    Double temperature;
    TemperatureUnitType fromUnit;
    TemperatureUnitType toUnit;

    static constraints = {
        temperature nullable: false
        fromUnit nullable: false
        toUnit nullable: false, validator: { value, object, errors ->
            if (value.equals(object.fromUnit)) {
                errors.rejectValue('toUnit', 'equal.reject')
            }
        }
    }
}
