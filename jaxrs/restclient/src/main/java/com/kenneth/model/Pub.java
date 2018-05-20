package com.kenneth.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pub {
	private String name;
	private Date openingHours;
	private Date closingHours;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(Date openingHours) {
		this.openingHours = openingHours;
	}
	public Date getClosingHours() {
		return closingHours;
	}
	public void setClosingHours(Date closingHours) {
		this.closingHours = closingHours;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
