package com.jsflabbing;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class Html5Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8343560969490844059L;
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void dodo(){
		int i = 0;
		
	}

}
