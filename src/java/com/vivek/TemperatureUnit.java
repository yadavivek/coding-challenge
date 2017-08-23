package com.vivek;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TemperatureUnit.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TemperatureUnit"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="degreeCelsius"/&gt;
 *     &lt;enumeration value="degreeFahrenheit"/&gt;
 *     &lt;enumeration value="degreeRankine"/&gt;
 *     &lt;enumeration value="degreeReaumur"/&gt;
 *     &lt;enumeration value="kelvin"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TemperatureUnit")
@XmlEnum
public enum TemperatureUnit {

    @XmlEnumValue("degreeCelsius")
    DEGREE_CELSIUS("degreeCelsius"),
    @XmlEnumValue("degreeFahrenheit")
    DEGREE_FAHRENHEIT("degreeFahrenheit"),
    @XmlEnumValue("degreeRankine")
    DEGREE_RANKINE("degreeRankine"),
    @XmlEnumValue("degreeReaumur")
    DEGREE_REAUMUR("degreeReaumur"),
    @XmlEnumValue("kelvin")
    KELVIN("kelvin");
    public final String value;

    TemperatureUnit(String v) {
        value = v;
    }

    public static TemperatureUnit fromValue(String v) {
        for (TemperatureUnit c : TemperatureUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }

}
