package com.jsflabbing;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ImmediateController  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1057605939124607913L;
	private String name;
	private String address;
	private String myText;
	private String password;
	private String password2;
	
	
	public void doSubmit(){
		System.out.println("doSubmit:"+FacesContext.getCurrentInstance().getCurrentPhaseId());
	}

	public String doNotSubmit(){
		System.out.println("doNotSubmit:"+FacesContext.getCurrentInstance().getCurrentPhaseId());
		return "Notexist";
	}
	
	public void ajaxFunc(AjaxBehaviorEvent e){
		System.out.println("ajaxFunc:"+FacesContext.getCurrentInstance().getCurrentPhaseId());
		myText = "updated myText";
	}
	
	public String getMyText() {
		return myText;
	}

	public void setMyText(String myText) {
		this.myText = myText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPassword(){
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	
}
