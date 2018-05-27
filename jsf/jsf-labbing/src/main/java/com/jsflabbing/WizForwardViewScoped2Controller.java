package com.jsflabbing;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class WizForwardViewScoped2Controller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WizardModel m;

	private String neighbour;
	private String pet;

	@PostConstruct
	public void init() {
		m = (WizardModel) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("model");
		System.out.println("Size" + m.getSize());
	}

	public String getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(String neighbour) {
		this.neighbour = neighbour;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String submit() {
		m.setNeighbour(neighbour);
		m.setPet(pet);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("model", m);
		return "wiz_forward_viewscoped_3";
	}

}
