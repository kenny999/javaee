package com.cditest;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.cditest.ejb.MyTestEJB;

@ViewScoped
@Named
public class TestOfScopesInEJBs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberPageViews;
	
	@EJB MyTestEJB myTestEJB;
	public void submit() {
		numberPageViews++;
		myTestEJB.f();
		int i = 0;

	}
	public int getNumberPageViews() {
		return numberPageViews;
	}
	public void setNumberPageViews(int numberPageViews) {
		this.numberPageViews = numberPageViews;
	}
}
