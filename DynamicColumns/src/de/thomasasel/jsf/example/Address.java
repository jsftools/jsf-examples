package de.thomasasel.jsf.example;

public class Address {

	private String street;

	private String number;

	private String city;

	private int zipCode;

	public Address() {}

	public Address(final String street, final String number, final String city, final int zipCode) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(final int zipCode) {
		this.zipCode = zipCode;
	}


}
