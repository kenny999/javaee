package com.jsflabbing;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class SessionViewScoped implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -571859568173524756L;
	private String message = "Hello from SessionViewScoped";

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void destroy(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
