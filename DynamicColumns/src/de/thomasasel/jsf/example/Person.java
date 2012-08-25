package de.thomasasel.jsf.example;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = -4631820884599914786L;

	private String firstname;

	private String lastname;

	private Address address;

	public Person() {}

	public Person(final String firstname, final String lastname, final Address address,
			final String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	private String email;

}
