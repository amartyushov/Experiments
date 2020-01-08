package io.mart.custom;

public class Address {
	
	private String street;
	private int houseNumber;
	
	
	public String getStreet() {
		return street;
	}
	
	
	public Address setStreet(String street) {
		this.street = street;
		return this;
	}
	
	
	public int getHouseNumber() {
		return houseNumber;
	}
	
	
	public Address setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}
}
