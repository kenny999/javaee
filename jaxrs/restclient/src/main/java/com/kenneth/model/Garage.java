package com.kenneth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Garage {
	
	private int numberOfCars;
	private String street;
	private String name;
	public int getNumberOfCars() {
		return numberOfCars;
	}
	public void setNumberOfCars(int numberOfCars) {
		this.numberOfCars = numberOfCars;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
