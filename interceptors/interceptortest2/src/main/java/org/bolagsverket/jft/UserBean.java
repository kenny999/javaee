package org.bolagsverket.jft;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@ViewScoped
public class UserBean implements Serializable {

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName;

	public String submit() {
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		ExternalContext externalContext = currentInstance.getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		session.setAttribute("USER_NAME", userName);
		return "kalkylator.xhtml?faces-redirect=true";
	}

	private static final long serialVersionUID = 1L;
}
