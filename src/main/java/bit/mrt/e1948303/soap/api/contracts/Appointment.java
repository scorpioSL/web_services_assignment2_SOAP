//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.09.04 at 02:36:38 PM IST 
//


package bit.mrt.e1948303.soap.api.contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Appointment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Appointment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reference_number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="student_index_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="is_canceled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Appointment", propOrder = {
    "id",
    "referenceNumber",
    "studentIndexNumber",
    "isCanceled"
})
public class Appointment {

    protected int id;
    @XmlElement(name = "reference_number")
    protected int referenceNumber;
    @XmlElement(name = "student_index_number", required = true)
    protected String studentIndexNumber;
    @XmlElement(name = "is_canceled")
    protected boolean isCanceled;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the referenceNumber property.
     * 
     */
    public int getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     */
    public void setReferenceNumber(int value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the studentIndexNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStudentIndexNumber() {
        return studentIndexNumber;
    }

    /**
     * Sets the value of the studentIndexNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStudentIndexNumber(String value) {
        this.studentIndexNumber = value;
    }

    /**
     * Gets the value of the isCanceled property.
     * 
     */
    public boolean isIsCanceled() {
        return isCanceled;
    }

    /**
     * Sets the value of the isCanceled property.
     * 
     */
    public void setIsCanceled(boolean value) {
        this.isCanceled = value;
    }

}