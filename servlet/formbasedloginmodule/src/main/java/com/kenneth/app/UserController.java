package com.kenneth.app;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class UserController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Principal principal;
	private String username;
	
	@PostConstruct
	public void init(){
		username = principal.getName();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
