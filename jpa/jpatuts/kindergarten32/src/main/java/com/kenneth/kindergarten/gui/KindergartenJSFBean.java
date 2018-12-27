package com.kenneth.kindergarten.gui;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Child;
import com.kenneth.kindergarten.entities.Educator;
import com.kenneth.kindergarten.entities.Garment;
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
		
		Educator e = kindergartenBean.getEducatorOfChild("Elin");
		
		System.out.println("Educator name:"+e.getName());
		
		Garment g = kindergartenBean.getGarmentByNameForChild("Elis", "Spidermantröja");

		System.out.println("Garment name:"+g.getName());
		
		List<Child> childs = kindergartenBean.findAllChildsOfAgeGreaterThanInclusive(4);
		
		for(Child c : childs){
			System.out.println("Child "+c.getName()+" has age "+c.getAge());
		}
		
		Child ch = kindergartenBean.findChildWithStartDatesBetween2016And2017();
		
		System.out.println("Child between 2016 and 2017:"+ch.getName());
		
		List<Educator> educators = kindergartenBean.findEducatorWhosChildsHasGarmentName("%Gul%");
		
		educators.stream().forEach(ed -> System.out.println(ed.getName()));
	
	}
	
	@Inject
	KindergartenBean b;
	
	public void g(){
		
		b.kalle(7);
		
		
	}

}
