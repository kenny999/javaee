package com.registration.jsf.beans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.registration.persistence.RegisteredUser;

@ViewScoped
@Named
public class RegisterBean implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = -65777911853465356L;
	private String userName;
	private Integer birthYear;
	private Integer birthMonth;
	private Integer birthDay;

	public String submitPage1() {
		RegisteredUser registeredUser = new RegisteredUser();
		registeredUser.setUserName(userName);
		registeredUser.setBirthDate(LocalDate.of(birthYear, birthMonth, birthDay));
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.setKeepMessages(false);
		flash.put("registeredUser", registeredUser);
		return "registerpage2.xhtml?faces-redirect=true";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public Integer getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}

	public Integer getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}
}
