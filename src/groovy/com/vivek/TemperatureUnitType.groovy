package com.vivek

/**
 * Created by vivek on 22/8/17.
 */
public enum TemperatureUnitType {

    DEGREE_CELSIUS("degreeCelsius"),
    DEGREE_FAHRENHEIT("degreeFahrenheit"),
    DEGREE_RANKINE("degreeRankine"),
    DEGREE_REAUMUR("degreeReaumur"),
    KELVIN("kelvin");

    final String value

    TemperatureUnitType(String value) { this.value = value }

    String toString() { value }

    String getKey() { name() }
}
