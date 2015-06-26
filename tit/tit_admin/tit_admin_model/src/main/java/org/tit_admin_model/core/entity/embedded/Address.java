package org.tit_admin_model.core.entity.embedded;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * Address embeddable entity
 *
 * @author: 刘晓勇
 */
@SuppressWarnings("restriction")
@XStreamAlias("address")
@XmlRootElement(name = "address")
public @Data class Address {
	@XmlElement @NotNull
	private String streetAddress;
	@XmlElement @NotNull 
    private String city;
	@XmlElement @NotNull
    private String state;
	@XmlElement @NotNull 
    private String country;
	@XmlElement @NotNull 
    private String postalCode;

    @Override public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
