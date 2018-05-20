package com.beanval1.model;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.groups.ConvertGroup;

public class Accountant {

	
	@AssertTrue(groups = Group1.class)
	private Boolean hasHouse;

	@AssertTrue(groups = Group2.class)
	private Boolean hasWife;

	@Valid
	@ConvertGroup(from = Group1.class, to = Car.Group1.class)
	private Car car;

	public void setHasHouse(boolean b) {
		this.hasHouse = b;
	}
	
	public interface Group1 {}
	public interface Group2 {}
	public void setCar(Car car) {
		this.car = car;
		
	}

}
