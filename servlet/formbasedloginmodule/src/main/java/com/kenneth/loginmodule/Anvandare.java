package com.kenneth.loginmodule;

import java.security.Principal;

public class Anvandare implements Principal {
	
	private String name;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String string) {
		this.name = string;
	}

	public Object getRoller() {
		// TODO Auto-generated method stub
		return null;
	}

}
