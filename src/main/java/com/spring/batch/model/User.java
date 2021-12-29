package com.spring.batch.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	public int id;
	public String name;
	public String username;
	public String email;
	public Address address;
	public String phone;
	public String website;
	public Company company;
	
	public User() {}

	public User(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Address getAdress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id= " + id + ", name= " + name + ", username= " + username + ", adress= " + address + ", website= "
				+ website + ", company= " + company + "]";
	}
	
	
	
}
