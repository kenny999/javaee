package com.userdebuglog;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import interceptors.UserDebugLogImpl;

@Named
@SessionScoped
public class UserDebugBean implements Serializable {
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName;

	public void submit() {
		UserDebugLogImpl.debugUserName = userName;
	}

	private static final long serialVersionUID = 1L;
}
