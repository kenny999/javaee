package com.jsflabbing;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class ViewParamController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;

	public String getUserId() {
		System.out.println("ViewParamController.getUserId:"+FacesContext.getCurrentInstance().getCurrentPhaseId());		
		return userId;
	}

	public void setUserId(String userId) {
		System.out.println("ViewParamController.setUserId:"+FacesContext.getCurrentInstance().getCurrentPhaseId());
		this.userId = userId;
	}
	
	public void onLoad(){
		System.out.println("ViewParamController.onLoad:"+FacesContext.getCurrentInstance().getCurrentPhaseId());		
	}
	
	public String sendViewParamsToNextPage(){
		System.out.println("ViewParamController.sendViewParamsToNextPage:"+FacesContext.getCurrentInstance().getCurrentPhaseId());		
		return "viewparam3?faces-redirect=true&userId="+userId;
	}

}
