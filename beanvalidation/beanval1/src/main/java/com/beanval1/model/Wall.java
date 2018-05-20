package com.beanval1.model;

import javax.validation.constraints.NotNull;

import com.beanval1.rest.Examples;

public class Wall {

	@NotNull(groups = Examples.Group1.class)
	private Integer color;
	
	@NotNull(groups = Examples.Group2.class)
	private String surface;

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer i) {
		this.color = i;
	}

}
