package com.vivek;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ConvertTempResult" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "convertTempResult"
})
@XmlRootElement(name = "ConvertTempResponse")
public class ConvertTempResponse {

    @XmlElement(name = "ConvertTempResult")
    protected double convertTempResult;

    /**
     * Gets the value of the convertTempResult property.
     */
    public double getConvertTempResult() {
        return convertTempResult;
    }

    /**
     * Sets the value of the convertTempResult property.
     */
    public void setConvertTempResult(double value) {
        this.convertTempResult = value;
    }

}
