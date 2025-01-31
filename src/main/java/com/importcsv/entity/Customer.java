package com.importcsv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastNam;
	private String company;
	private String city;
	private String country;
	private String phone1;
	private String phone2;
	private String email;
	private String subscriptionDate;
	private String website;

	public Customer() {

	}

	public Customer(int id, String firstName, String lastNam, String company, String city, String country,
			String phone1, String phone2, String email, String subscriptionDate, String website) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastNam = lastNam;
		this.company = company;
		this.city = city;
		this.country = country;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.subscriptionDate = subscriptionDate;
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNam() {
		return lastNam;
	}

	public void setLastNam(String lastNam) {
		this.lastNam = lastNam;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

}
