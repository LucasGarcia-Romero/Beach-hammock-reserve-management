
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

@XmlRootElement(name = "addReserveResponse", namespace = "http://student.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addReserveResponse", namespace = "http://student.com/")

public class AddReserveResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}

