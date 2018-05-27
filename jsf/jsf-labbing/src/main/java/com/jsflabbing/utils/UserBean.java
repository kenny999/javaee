package com.jsflabbing.utils;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class UserBean implements Serializable {
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	@PostConstruct
	public void resetUser(){
		user = new User();;
	}

}
