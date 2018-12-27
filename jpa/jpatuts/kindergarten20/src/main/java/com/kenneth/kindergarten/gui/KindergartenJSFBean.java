package com.kenneth.kindergarten.gui;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Kindergarten;

@Named
@ViewScoped
public class KindergartenJSFBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int numToCreate;
	
	public int getNumToCreate() {
		return numToCreate;
	}

	public void setNumToCreate(int numToCreate) {
		this.numToCreate = numToCreate;
	}

	@Inject
	KindergartenBean kindergartenBean;
	
	public void createMoreKids(){
		
		kindergartenBean.createMoreKids(numToCreate);
		
	}

	public String browseKids(){
		return "browse.xhtml?faces-redirect=true";
	}

}
