package com.spring.batch.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	public String street;
	public String suite;
	public String city;
	public String zipcode;
	public Geolocalization geo;
	
	public Address() {}

	public Address(String street, String suite, String city, String zipcode, Geolocalization geo) {
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
		this.geo = geo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Geolocalization getGeo() {
		return geo;
	}

	public void setGeo(Geolocalization geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "Address { street= " + street + ", suite= " + suite + ", city= " + city + ", zipcode= " + zipcode + ", geo= "
				+ geo + " }";
	}
	
	
	
}
