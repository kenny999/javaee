package com.jsflabbing;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class WizPrgViewScoped1Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String size;
	
	public String submit(){
		WizardModel m = new WizardModel();
		m.setName(name);
		m.setSize(size);
	    Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
	    flash.setKeepMessages(true);
		flash.put("model", m);
	    return "wiz_prg_viewscoped_2?faces-redirect=true";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
