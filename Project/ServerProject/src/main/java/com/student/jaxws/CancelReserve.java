
package com.student.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.6.2
 * Wed Jan 03 13:40:17 CET 2024
 * Generated source version: 3.6.2
 */

@XmlRootElement(name = "cancelReserve", namespace = "http://student.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelReserve", namespace = "http://student.com/")

public class CancelReserve {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}

