package com.kenneth.kindergarten.gui;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Child;
import com.kenneth.kindergarten.entities.ChildDTO;
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
		
		Child c = kindergartenBean.findChildByNameNative("Elin");
		System.out.println("id:"+c.getId()+",name:"+c.getName());
		
		List<Child> childs = kindergartenBean.findAllChildsNative();
		
		childs.stream().forEach(ch -> System.out.println(ch.getName()));

		List<ChildDTO> childDTOs = kindergartenBean.findAllChildsNativeSqlResultSet();
		
		childDTOs.stream().forEach(ch -> System.out.println(ch.getName()));

	}

}
