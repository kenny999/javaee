package com.jsflabbing;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class FlashBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4325841475761856091L;

	public String redirect() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.put("redirectMessage", "HELLO");
		return "flash_page2?faces-redirect=true";
	}

	public String forward() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.setKeepMessages(false);
		flash.put("forwardMessage", "JELLO");
		return "flash_page2";
	}
}