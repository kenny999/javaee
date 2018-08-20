package com.ca1;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.TransactionAttributeType;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class CaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doIt() {
		try {
			f();
			g();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@EJB
	MyEJB myEJB;
	
	private void f() {
		// This prints STATUS_NO_TRANSACTION as SuperclassEJB has TransactionAttributeType.NEVER
		// which is inherited to MyEJB
		myEJB.foo();
		myEJB.bar();
	}
	

	@EJB
	SuperInterface myEJB2;
	
	private void g() {
		// This prints STATUS_ACTIVE as SuperInterface has TransactionAttributeType.REQUIRED
		// which cannot be overridden
		myEJB2.f();
	}
}
