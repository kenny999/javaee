package com.jsflabbing;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class ViewParam3Controller implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;

	public String getUserId() {
		System.out.println("ViewParam3Controller.getUserId:"+FacesContext.getCurrentInstance().getCurrentPhaseId());
		return userId;
	}

	public void setUserId(String userId) {
		System.out.println("ViewParam3Controller.setUserId:"+FacesContext.getCurrentInstance().getCurrentPhaseId());
		this.userId = userId;
	}
}
