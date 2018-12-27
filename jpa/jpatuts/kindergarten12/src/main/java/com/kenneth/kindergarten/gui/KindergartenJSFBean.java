package com.kenneth.kindergarten.gui;

import java.io.Serializable;

import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Child;

@Named
@ViewScoped
public class KindergartenJSFBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String childName;

	@Inject
	ChildHolder childHolder;

	@Inject
	KindergartenBean kindergartenBean;

	private String error;
	
	public void create(){
		kindergartenBean.create();		
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String doIt() {
		try {
			Child child = kindergartenBean.findChildWithName(childName);
			childHolder.setChild(child);
			return "edit.xhtml?faces-redirect=true";
		} catch (EJBException e) {
			if (e.getCause() instanceof NoResultException) {
				error = "Child not found";
			}
			return null;
		}
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

}
