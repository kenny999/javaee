package com.jsflabbing;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class LocaleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4992183155625755703L;

	private Locale locale;

	private String language;
	
	@PostConstruct
	private void init(){
		language ="se";
		this.locale = new Locale(language);	
	}
	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void press(){
		this.locale = new Locale(language);
	}
}
