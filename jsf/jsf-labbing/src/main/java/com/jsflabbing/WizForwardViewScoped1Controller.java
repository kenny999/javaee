package com.jsflabbing;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class WizForwardViewScoped1Controller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String size;
	
	public String submit(){
		WizardModel m = new WizardModel();
		m.setName(name);
		m.setSize(size);
	    FacesContext.getCurrentInstance().getExternalContext().getFlash().put("model", m);
	    return "wiz_forward_viewscoped_2";
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
