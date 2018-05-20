package com.beanval1.model;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;

public class Car {

	@NotNull(groups = Car.Group1.class)
	private String model;

	@AssertFalse(groups = Car.Group2.class)
	private boolean motorIsBroken;

	public void setModel(String string) {
		this.model = string;
	}

	public void setMotorIsBroken(boolean b) {
		this.motorIsBroken = b;
	}
	
	public String getModel() {
		return model;
	}

	public boolean isMotorIsBroken() {
		return motorIsBroken;
	}

	public interface Group1 {
	}

	public interface Group2 {
	}


}
