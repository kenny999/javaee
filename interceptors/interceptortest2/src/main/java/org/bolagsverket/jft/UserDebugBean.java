package org.bolagsverket.jft;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.bolagsverket.jft.interceptors.UserDebugLogImpl;

@Named
@ViewScoped
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
