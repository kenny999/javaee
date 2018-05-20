package com.wsusertrace.vetoed;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CurrentCustomerExecution {
	
	private String kundnr;

	public String getKundnr() {
		return kundnr;
	}

	public void setKundnr(String kundnr) {
		this.kundnr = kundnr;
	}

}
