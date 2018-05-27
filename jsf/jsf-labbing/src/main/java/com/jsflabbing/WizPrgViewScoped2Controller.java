package com.jsflabbing;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class WizPrgViewScoped2Controller implements Serializable {

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
		if (m != null) {
			System.out.println("Size" + m.getSize());
		}
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
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.put("model", m);
		return "wiz_prg_viewscoped_3?faces-redirect=true";
	}

}
