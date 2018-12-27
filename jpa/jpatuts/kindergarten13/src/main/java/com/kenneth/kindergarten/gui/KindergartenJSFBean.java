package com.kenneth.kindergarten.gui;

import java.io.Serializable;

import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Garment;
import com.kenneth.kindergarten.entities.Kindergarten;

@Named
@ViewScoped
public class KindergartenJSFBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int errors = 0;

	@Inject
	KindergartenBean kindergartenBean;
	public void doIt(){
		System.out.println("Hello kindergarten");
		Kindergarten k = kindergartenBean.create();
		
		kindergartenBean.addChildToFirstSectionOfKindergarten(k.getId());
		kindergartenBean.addGarmentToChild(k, "Mille");
		
		errors = 0;
		saveGarmentValidatedByEJB();
		saveGarmentValidatedByJPA();
		
		if(errors == 2){
			System.out.println("ALL OK");
		}
		
	}
	private void saveGarmentValidatedByJPA() {
		
		Garment garment = new Garment();
		garment.setName("ab"); // TOO SHORT
		try {
			kindergartenBean.saveGarmentValidatedByJPA(garment);
		} catch (EJBException e) {
			errors++;
			System.out.println("OK");
		}
	}
	private void saveGarmentValidatedByEJB() {
		
		Garment garment = new Garment();
		garment.setName("ab"); // TOO SHORT
		try {
			kindergartenBean.saveGarmentValidatedByEJB(garment);
		} catch (EJBException e) {
			errors++;
			System.out.println("OK");
		}
	}

}
