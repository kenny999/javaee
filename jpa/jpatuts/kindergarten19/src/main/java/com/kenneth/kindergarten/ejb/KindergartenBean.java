package com.kenneth.kindergarten.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.kenneth.kindergarten.entities.Child;
import com.kenneth.kindergarten.entities.Educator;
import com.kenneth.kindergarten.entities.Garment;
import com.kenneth.kindergarten.entities.Kindergarten;
import com.kenneth.kindergarten.entities.Section;
import com.kenneth.kindergarten.entities.Toy;

@Stateless
public class KindergartenBean {
	
	@PersistenceContext
	private EntityManager em;

	public Kindergarten create() {
		
		// Create the Kindergarten Böleängen.
		// Create the section Ekan.
		// Create the Children Elin, Manda and Mille
		// Create the educators Kristian and Sandra
		// Set Elin and Manda as children of Kristian
		// Set Mille as child of Sandra
		// Create "Gul tröja" and "Lurviga byxor" as garments of Elin
		// Create "Onepiece" as garment of Manda
		// Create "Stor mössa" and "Tuffa skor" as garments of Mille
		
		
		Kindergarten kindergarten = new Kindergarten();
		kindergarten.setName("Böleängen");
		Section section = new Section();
		section.setName("Ekan");
		section.setKindergarten(kindergarten);
		Collection<Section> sections = new ArrayList<>();
		sections.add(section);
		kindergarten.setSections(sections);
		
		Collection<Child> childrenOfEkan = new ArrayList<>();
		Child childElin = createChildWithName("Elin", section);
		childrenOfEkan.add(childElin);
		Child childManda = createChildWithName("Manda", section);
		childrenOfEkan.add(childManda);
		Child childMille = createChildWithName("Mille", section);
		childrenOfEkan.add(childMille);

		Collection<Child> childrenOfKristian = new ArrayList<>();
		childrenOfKristian.add(childElin);
		childrenOfKristian.add(childManda);

		Educator educatorKristian = createEducatorWithNameAndChilds("Kristian", childrenOfKristian);

		Collection<Child> childrenOfSandra = new ArrayList<>();
		childrenOfSandra.add(childMille);
		Educator educatorSandra = createEducatorWithNameAndChilds("Sandra", childrenOfSandra);

		associateEducatorWithSection(educatorKristian, section);
		associateEducatorWithSection(educatorSandra, section);
		
		setGarmentToChild(childElin, "Gul tröja");
		setGarmentToChild(childElin, "Lurviga byxor");
		setGarmentToChild(childManda, "Onepiece");
		setGarmentToChild(childMille, "Stor mössa");
		setGarmentToChild(childMille, "Tuffa skor");
		
		createToys();
		
		em.persist(section);
		em.persist(kindergarten);
		for(Child child : childrenOfEkan){
			em.persist(child);
			for(Garment garment : child.getGarments()){
				em.persist(garment);
			}
		}
		for(Educator educator : section.getEducators()){
			em.persist(educator);
		}
		return kindergarten;
	}
	
	private void createToys() {
		
		Toy t1 = new Toy();
		t1.setName("Spade");
		Toy t2 = new Toy();
		t2.setName("Hink");
		Toy t3 = new Toy();
		t3.setName("Lego");
		Toy t4 = new Toy();
		t4.setName("Bil");
		
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
	}

	private void associateEducatorWithSection(Educator educator, Section section) {
		educator.setSection(section);
		Collection<Educator> educators = section.getEducators();
		if(educators == null){
			educators = new ArrayList<>();
			section.setEducators(educators);
		}
		educators.add(educator);
	}

	private Educator createEducatorWithNameAndChilds(String name, Collection<Child> childs) {
		Educator educator = new Educator();
		educator.setName(name);
		for(Child child : childs){
			child.setEducator(educator);
		}	
		educator.setChilds(childs);
		return educator;
	}

	private void setGarmentToChild(Child child, String name) {
		Garment garment = new Garment();
		garment.setName(name);
		garment.setChild(child);
		Collection<Garment> garments = child.getGarments();
		if(garments == null){
			garments = new ArrayList<>();
		}
		garments.add(garment);
		child.setGarments(garments);		
	}

	private Child createChildWithName(String name, Section section){
		Child child = new Child();
		child.setName(name);
		child.setSection(section);
		Collection<Child> childs = section.getChilds();
		if(childs == null){
			childs = new ArrayList<>();
		}
		childs.add(child);
		section.setChilds(childs);
		return child;
	}


	public void addChildToFirstSectionOfKindergarten(Long kindergartenId) {
		
		// Add child Elis, with Garments Spidermantröja
		// Associate Elis with the first section
		// Associate Elis with the first Educator of this section
		
		Kindergarten kindergarten = em.find(Kindergarten.class, kindergartenId);

		Child child = new Child();
		child.setName("Elis");
		
		Garment garment = new Garment();
		garment.setName("Spidermantröja");
		garment.setChild(child);
		Collection<Garment> garments = new ArrayList<>();
		garments.add(garment);
		child.setGarments(garments);
		
		em.persist(garment);
		em.persist(child);
		
		Collection<Section> sections = kindergarten.getSections();
		
		if(sections.size() > 0){
			for(Section section : sections){
				Collection<Child> childs = section.getChilds();
				childs.add(child);
				child.setSection(section);
				Collection<Educator> educators = section.getEducators();
				for(Educator educator : educators){
					educator.setChilds(new ArrayList<>(childs));
					child.setEducator(educator);
					break;
				}							
				break;
			}
		}
	}
	
	public void addGarmentToChild(Kindergarten kindergarten, String childName){
		
		// Add garment "Blå vantar" to Mille
		
		kindergarten = em.merge(kindergarten);
		
		TypedQuery<Child> query = em.createNamedQuery(Child.findChildByName, Child.class);
		query.setParameter("childName", childName);
		Child child = query.getSingleResult();
		if(child != null){
			Garment garment = new Garment();
			garment.setName("Blå vantar");
			garment.setChild(child);
			Collection<Garment> garments = new ArrayList<>();
			garments.add(garment);
			child.setGarments(garments);			
			em.persist(garment);
		}
	}

	public void setToysForChild(String childName) {
		
		TypedQuery<Child> query = em.createNamedQuery(Child.findChildByName, Child.class);
		query.setParameter("childName", childName);
		Child child = query.getSingleResult();

		TypedQuery<Toy> querySpade = em.createNamedQuery(Toy.findToyByName, Toy.class);
		querySpade.setParameter("toyName", "Spade");
		Toy spade = querySpade.getSingleResult();

		TypedQuery<Toy> queryHink = em.createNamedQuery(Toy.findToyByName, Toy.class);
		queryHink.setParameter("toyName", "Hink");
		Toy hink = queryHink.getSingleResult();
		
		TypedQuery<Toy> queryLego = em.createNamedQuery(Toy.findToyByName, Toy.class);
		queryLego.setParameter("toyName", "Lego");
		Toy lego = queryLego.getSingleResult();

		TypedQuery<Toy> queryBil = em.createNamedQuery(Toy.findToyByName, Toy.class);
		queryBil.setParameter("toyName", "Bil");
		Toy bil = queryBil.getSingleResult();
		
		if(childName.equals("Elin")){
			child.getToys().add(lego);
			lego.getChilds().add(child);			
			child.getToys().add(hink);
			hink.getChilds().add(child);			
			child.getToys().add(spade);
			spade.getChilds().add(child);
			child.getToys().add(bil);
			bil.getChilds().add(child);
		} else if(childName.equals("Manda")){
			child.getToys().add(hink);
			hink.getChilds().add(child);			
		} else if(childName.equals("Mille")){
			child.getToys().add(spade);
			spade.getChilds().add(child);
		} else if(childName.equals("Elis")){
			child.getToys().add(bil);
			bil.getChilds().add(child);
		}
	}

}
