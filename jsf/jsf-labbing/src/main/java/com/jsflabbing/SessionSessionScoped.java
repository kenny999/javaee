package com.jsflabbing;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class SessionSessionScoped implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1458066209362310870L;
	private String message = "Hello from SessionSessionScoped";

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
