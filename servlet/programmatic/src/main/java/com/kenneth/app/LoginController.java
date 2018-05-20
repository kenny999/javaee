package com.kenneth.app;

import java.io.Serializable;
import java.security.Principal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	@Inject
	private LoggedInUser loggedInUser;
	
	@Inject
	Principal principal;

	public void loginUser() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		try {
			request.login(userName, password);
			loggedInUser.setLoggedIn(true);
			loggedInUser.setUserName(userName);
			if (request.isUserInRole("user")) {
				loggedInUser.setInUserRole(true);
			} else if (request.isUserInRole("admin")) {
				loggedInUser.setInAdminRole(true);
			}
			String s = principal.getName();
			int j = 0;
		} catch (ServletException e) {
			FacesMessage message = new FacesMessage("Login failed");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", message);
			return;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
