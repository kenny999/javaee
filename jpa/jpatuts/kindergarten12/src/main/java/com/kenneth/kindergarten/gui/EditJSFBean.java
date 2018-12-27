package com.kenneth.kindergarten.gui;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Child;

@Named
@ViewScoped
public class EditJSFBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Child child;
	
	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	@Inject ChildHolder childHolder;
	
	@PostConstruct
	public void pCon(){
		child = childHolder.getChild();
	}

	@Inject
	KindergartenBean kindergartenBean;

	private String error;

	public void doIt() {
		try {
			kindergartenBean.saveModifiedChild(child);
		} catch (EJBException e) {
			if (e.getCause() instanceof OptimisticLockException) {
				error = "Child edited by other user";
			}
		}
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
