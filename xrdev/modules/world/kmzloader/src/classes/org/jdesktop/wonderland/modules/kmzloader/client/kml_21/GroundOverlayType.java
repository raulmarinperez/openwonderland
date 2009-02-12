/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * Sun designates this particular file as subject to the "Classpath" 
 * exception as provided by Sun in the License file that accompanied 
 * this code.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.09.19 at 09:37:59 AM PDT 
//


package org.jdesktop.wonderland.modules.kmzloader.client.kml_21;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroundOverlayType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroundOverlayType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://earth.google.com/kml/2.1}OverlayType">
 *       &lt;sequence>
 *         &lt;element name="altitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="altitudeMode" type="{http://earth.google.com/kml/2.1}altitudeModeEnum" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.1}LatLonBox" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroundOverlayType", propOrder = {
    "altitude",
    "altitudeMode",
    "latLonBox"
})
public class GroundOverlayType
    extends OverlayType
{

    @XmlElement(defaultValue = "0")
    protected Double altitude;
    @XmlElement(defaultValue = "clampToGround")
    protected AltitudeModeEnum altitudeMode;
    @XmlElement(name = "LatLonBox")
    protected LatLonBoxType latLonBox;

    /**
     * Gets the value of the altitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAltitude() {
        return altitude;
    }

    /**
     * Sets the value of the altitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAltitude(Double value) {
        this.altitude = value;
    }

    /**
     * Gets the value of the altitudeMode property.
     * 
     * @return
     *     possible object is
     *     {@link AltitudeModeEnum }
     *     
     */
    public AltitudeModeEnum getAltitudeMode() {
        return altitudeMode;
    }

    /**
     * Sets the value of the altitudeMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AltitudeModeEnum }
     *     
     */
    public void setAltitudeMode(AltitudeModeEnum value) {
        this.altitudeMode = value;
    }

    /**
     * Gets the value of the latLonBox property.
     * 
     * @return
     *     possible object is
     *     {@link LatLonBoxType }
     *     
     */
    public LatLonBoxType getLatLonBox() {
        return latLonBox;
    }

    /**
     * Sets the value of the latLonBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatLonBoxType }
     *     
     */
    public void setLatLonBox(LatLonBoxType value) {
        this.latLonBox = value;
    }

}
