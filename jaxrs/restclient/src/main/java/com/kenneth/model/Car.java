package com.kenneth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {
	
	private String brand;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	private String description;
	private String model;
	

}
