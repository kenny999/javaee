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
		
		Child c = kindergartenBean.getChildWithEducatorAndChilds1("Elin");
		System.out.println("Educator name: "+c.getEducator().getName());
		for(Child c2: c.getEducator().getChilds()){
			System.out.println("Child name of this educator: "+c2.getName());			
		}
		c = kindergartenBean.getChildWithEducatorAndChilds2("Elin");
		System.out.println("Educator name: "+c.getEducator().getName());
		for(Child c2: c.getEducator().getChilds()){
			System.out.println("Child name of this educator: "+c2.getName());			
		}	
		c = kindergartenBean.getChildWithEducatorAndChilds3("Elin");
		System.out.println("Educator name: "+c.getEducator().getName());
		for(Child c2: c.getEducator().getChilds()){
			System.out.println("Child name of this educator: "+c2.getName());			
		}
	}

}
