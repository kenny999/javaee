package com.beanval1.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Point {

	@NotNull(message = "{com.beanval1.xNotNull}")
	@Min(value = -128, message = "{com.beanval1.xMin}")
	@Max(value = 128, message = "{com.beanval1.xMax}")
	private Integer x;

	@NotNull(message = "{com.beanval1.yNotNull}")
	@Min(value = -128, message = "{com.beanval1.yMin}")
	@Max(value = 128, message = "{com.beanval1.yMax}")
	private Integer y;

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	

}
