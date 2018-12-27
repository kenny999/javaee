package com.kenneth.kindergarten.gui;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Child;
import com.kenneth.kindergarten.entities.Kindergarten;
import com.kenneth.kindergarten.entities.Section;

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
		
		Section s = kindergartenBean.readSectionWithName("Ekan");
		Collection<Child> childs = s.getChilds();
		for(Child c : childs){
			if(c.getName().equals("Elin")){
				c.setName("ElinPelin");
				s.setName("Ekan2");
				kindergartenBean.saveModifiedSection(s);
				break;
			}
		}
		
		int i = 0;
	}

}
