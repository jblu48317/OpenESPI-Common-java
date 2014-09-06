/*
 * Copyright 2013, 2014 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.27 at 01:43:57 PM EDT 
//


package org.energyos.espi.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.energyos.espi.common.models.atom.LinkType;


/**
 * This is a root class to provide common naming attributes for all classes needing naming attributes
 * <p/>
 * <p>Java class for IdentifiedObject complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="IdentifiedObject">
 *   &lt;complexContent>
 *     &lt;extension base="{http://naesb.org/espi}Resource">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://naesb.org/espi}UUIDType" minOccurs="0"/>
 *         &lt;element name="description" type="{http://naesb.org/espi}String32" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifiedObject")
@XmlSeeAlso({
        MeterReading.class,
        UsagePoint.class,
        ElectricPowerUsageSummary.class,
        TimeConfiguration.class,
        ApplicationInformation.class,
        Authorization.class,
        Subscription.class,
        ElectricPowerQualitySummary.class,
        IntervalBlock.class,
        ReadingType.class
})
@MappedSuperclass
public class IdentifiedObject extends Resource implements Linkable, Serializable {
	
    @XmlTransient
	private static final long serialVersionUID = -5263186855332223773L;

	public interface ResourceEnumClass {
		   ResourceEnum getEnumType();
	}
	
    @XmlTransient
    protected String description;

    @XmlTransient
    @NotNull
    protected String uuid;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    protected Long id;

    @XmlTransient
    protected GregorianCalendar updated = new GregorianCalendar();
    @XmlTransient
    protected GregorianCalendar published = new GregorianCalendar();

    @XmlTransient
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="rel", column = @Column(name="up_link_rel") ),
            @AttributeOverride(name="href", column = @Column(name="up_link_href") ),
    } )
    private LinkType upLink;

    @XmlTransient
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="rel", column = @Column(name="self_link_rel") ),
            @AttributeOverride(name="href", column = @Column(name="self_link_href") ),
    } )
    private LinkType selfLink;
    
    @XmlTransient
    // an enum to support class dispatching across the library
    //
    public enum ResourceEnum {
  	  RetailCustomer(0), UsagePoint(1), MeterReadingC(2), IntervalBlock(3),
  	  TimeConfiguration(4), ElectricPowerQualitySummary(5), ElectricPowerUsageSummary(6),
  	  ReadingType(7), Subscription(8), Authorization(9), ApplicationInformation(10);

  	  private int value;

  	  private ResourceEnum(final int value) {
  	    this.value = value;
  	  }

  	  public int getValue() {
  	    return value;
  	  }
    }
    	  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the value of the mrid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMRID() {
        if (uuid == null)
            return null;
        return "urn:uuid:" + uuid;
    }

    /**
     * Sets the value of the mrid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMRID(String value) {
        this.uuid = value.replace("urn:uuid:", "").toUpperCase();
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public GregorianCalendar getUpdated() {
        return updated;
    }

    public void setUpdated(GregorianCalendar updated) {
        this.updated = updated;
    }

    public GregorianCalendar getPublished() {
        return published;
    }

    public void setPublished(GregorianCalendar published) {
        this.published = published;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid.toString().toUpperCase();
        // make sure there is a uplink and a selflink
        // so marshalling works ...
        getSelfLink();
        getUpLink();
    }

    public UUID getUUID() {
        if (uuid != null)
            return UUID.fromString(uuid);
        return null;
    }

    public String getHashedId() {
        return "" + getUUID();
    }

    @Override
    public void setUpResource(IdentifiedObject resource) {
    }

    @Override
    public String getParentQuery() {
        return null;
    }

    @Override
    public String getAllRelatedQuery() {
        return null;
    }

    @Override
    public List<String> getRelatedLinkHrefs() {
        List<String> hrefs = new ArrayList<>();
        for(LinkType link : getRelatedLinks()) {
            hrefs.add(link.getHref());
        }
        return hrefs;
    }

    public List<LinkType> getRelatedLinks() {
        return new ArrayList<>();
    }

    public LinkType getUpLink() {
    	if (upLink == null) {
    		setUpLink(new LinkType());
    		upLink.setRel("up");
    	}
        return upLink;
    }

    public void setUpLink(LinkType upLink) {
        this.upLink = upLink;
    }

    public void merge(IdentifiedObject resource) {
        this.setSelfLink(resource.getSelfLink());
        this.setUpLink(resource.getUpLink());
        this.setDescription(resource.getDescription());
        this.setUpdated(resource.getUpdated());
        this.setPublished(resource.getPublished());
    }

    public LinkType getSelfLink() {
    	if (selfLink == null) {
    		setSelfLink(new LinkType());
    		selfLink.setRel("self");
    	}
        return selfLink;
    }

    public void setSelfLink(LinkType selfLink) {
        this.selfLink = selfLink;
    }

	public void unlink() {
		// there is really nothing to unlink here
		// so this is a stub for now
	}
}
