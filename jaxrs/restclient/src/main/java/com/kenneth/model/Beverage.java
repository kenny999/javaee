package com.kenneth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Beverage {
	private String name;
	private int quantity;
	private boolean isAlcoholic;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isAlcoholic() {
		return isAlcoholic;
	}
	public void setAlcoholic(boolean isAlcoholic) {
		this.isAlcoholic = isAlcoholic;
	}

}
