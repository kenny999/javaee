package com.kenneth.kindergarten.gui;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Child;
import com.kenneth.kindergarten.entities.Kindergarten;

@Named
@ViewScoped
public class KindergartenJSFBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	KindergartenBean kindergartenBean;
	public void doIt(){
		System.out.println("Hello kindergarten");
		Kindergarten k = kindergartenBean.create();
		
		kindergartenBean.addChildToFirstSectionOfKindergarten(k.getId());
		kindergartenBean.addGarmentToChild(k, "Mille");
		
		Child c = kindergartenBean.findChildWithName("Elin");
		
		System.out.println("Guardian name:"+c.getGuardian().getName());
		System.out.println("Guardian age:"+c.getGuardian().getAge());
	}

}
