package com.kenneth.app;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LoggedInUser implements Serializable {

	private static final long serialVersionUID = 1L;
	boolean loggedIn;
	String userName;
	private boolean isInUserRole;
	private boolean isInAdminRole;


	public boolean getIsInAdminRole() {
		return isInAdminRole;
	}
	public void setInAdminRole(boolean isInAdminRole) {
		this.isInAdminRole = isInAdminRole;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean getIsInUserRole() {
		return isInUserRole;
	}
	public void setInUserRole(boolean isInUserRole) {
		this.isInUserRole = isInUserRole;
	}

}
