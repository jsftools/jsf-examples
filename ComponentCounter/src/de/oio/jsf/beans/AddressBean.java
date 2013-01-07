package de.oio.jsf.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AddressBean implements Serializable {

	private static final long serialVersionUID = 4355784554232410340L;

	private String firstname;
	private String lastname;
	private String street;
	private String number;
	private String city;
	private String zip;
	
	public AddressBean() {}

	public AddressBean(String firstname, String lastname, String street,
			String number, String city, String zip) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.number = number;
		this.city = city;
		this.zip = zip;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	};
	
}
