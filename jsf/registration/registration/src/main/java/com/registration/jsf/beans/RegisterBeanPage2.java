package com.registration.jsf.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.registration.ejb.UserEJB;
import com.registration.persistence.RegisteredUser;
import com.registration.util.UrlData;

@ViewScoped
@Named
public class RegisterBeanPage2 implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 4194127019819327736L;
	private String email1;
	private String email2;
	private RegisteredUser registeredUser;
	private UrlData homePage;
	@EJB
	private UserEJB userEJB;

	public String prereqPage2() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		registeredUser = (RegisteredUser) flash.get("registeredUser");
		if (registeredUser == null) {
			return "index.xhtml";
		}
		return null;
	}

	public String register() {
		registeredUser.setEmail(email1);
		registeredUser.setHomePage(homePage.getUrl());
		userEJB.saveNewUser(registeredUser);
		return "successfulregistration.xhtml?faces-redirect=true";
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public UrlData getHomePage() {
		return homePage;
	}

	public void setHomePage(UrlData homePage) {
		this.homePage = homePage;
	}
	
	
}
