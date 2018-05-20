package com.beanval1.model;

import com.beanval1.constraints.MixedCase;

public class Hamburger {

	@MixedCase(numLowercase = 2, numUppercase = 5)
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
