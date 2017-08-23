package com.vivek;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.vivek package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Double_QNAME = new QName("http://www.webserviceX.NET/", "double");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vivek
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertTemp }
     */
    public ConvertTemp createConvertTemp() {
        return new ConvertTemp();
    }

    /**
     * Create an instance of {@link ConvertTempResponse }
     */
    public ConvertTempResponse createConvertTempResponse() {
        return new ConvertTempResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.webserviceX.NET/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

}
