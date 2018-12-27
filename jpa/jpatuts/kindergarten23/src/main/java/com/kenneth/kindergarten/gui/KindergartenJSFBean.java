package com.kenneth.kindergarten.gui;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Child;
import com.kenneth.kindergarten.entities.Garment;
import com.kenneth.kindergarten.entities.Kindergarten;
import com.kenneth.kindergarten.entities.Section;

@Named
@ViewScoped
public class KindergartenJSFBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	KindergartenBean kindergartenBean;

	public void doIt() {
		System.out.println("Hello kindergarten");
		Kindergarten k = kindergartenBean.create();

		kindergartenBean.addChildToFirstSectionOfKindergarten(k.getId());
		kindergartenBean.addGarmentToChild(k, "Mille");

		Child c = kindergartenBean.getChildWithGarments("Elin");
		for (Garment g : c.getGarments()) {
			System.out.println(g.getName());
		}

		Kindergarten k2 = kindergartenBean.getKindgartenWithSectionsAndChildsAndGarments("Böleängen");
		System.out.println(k2.getName());
		for (Section s : k2.getSections()) {
			System.out.println(s.getName());
			for (Child c2 : s.getChilds()) {
				System.out.println(c2.getName());
				for (Garment g : c2.getGarments()) {
					System.out.println(g.getName());
				}
			}

		}
	}

}
