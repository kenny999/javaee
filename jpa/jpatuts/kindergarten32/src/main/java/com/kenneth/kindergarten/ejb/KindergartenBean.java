package com.kenneth.kindergarten.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.kenneth.kindergarten.entities.Child;
import com.kenneth.kindergarten.entities.Educator;
import com.kenneth.kindergarten.entities.Garment;
import com.kenneth.kindergarten.entities.Kindergarten;
import com.kenneth.kindergarten.entities.Section;

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
		childElin.setAge(4);
		setDatesOnChild(childElin);
		childrenOfEkan.add(childElin);
		Child childManda = createChildWithName("Manda", section);
		childrenOfEkan.add(childManda);
		childManda.setAge(3);
		Child childMille = createChildWithName("Mille", section);
		childMille.setAge(6);
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
		child.setAge(2);

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

	public Educator getEducatorOfChild(String childName) {
		TypedQuery<Educator> query = em.createNamedQuery(Child.findEducatorOfChildByName, Educator.class);
		query.setParameter("childName", childName);
		Educator educator = query.getSingleResult();
		return educator;
	}

	public Garment getGarmentByNameForChild(String childName, String garmentName) {
		TypedQuery<Garment> query = em.createNamedQuery(Child.findGarmentOfChildByName, Garment.class);
		query.setParameter("childName", childName);
		query.setParameter("garmentName", garmentName);
		Garment g = query.getSingleResult();
		return g;
	}

	public List<Child> findAllChildsOfAgeGreaterThanInclusive(int age) {
		TypedQuery<Child> query = em.createNamedQuery(Child.findAllChildsOfAgeGreaterThanInclusive, Child.class);
		query.setParameter("age", age);
		List<Child> childs = query.getResultList();
		return childs;
	}
	
	private void setDatesOnChild(Child childElin) {	    
	    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mm-dd");
		Date startDate = null;
		try {
			startDate = formatter2.parse("2016-01-07");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		childElin.setStartDate(startDate);
	}

	public Child findChildWithStartDatesBetween2016And2017() {
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mm-dd");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = formatter2.parse("2016-01-01");
			d2 = formatter2.parse("2017-01-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		TypedQuery<Child> query = em.createNamedQuery(Child.findChildBetweenDates, Child.class);
		query.setParameter("d1", d1, TemporalType.DATE);
		query.setParameter("d2", d2, TemporalType.DATE);
		Child child = query.getSingleResult();		
		return child;
	}

	public void kalle(int i) {
		// TODO Auto-generated method stub
		
	}

	public List<Educator> findEducatorWhosChildsHasGarmentName(String name) {
		
		System.out.println("Enter findEducatorWhosChildsHasGarmentName");
		
		String jpql = "select e from Educator e join e.childs ch join ch.garments ga where ga.name like :garmentName";
		
		TypedQuery<Educator> query = em.createQuery(jpql, Educator.class);
		query.setParameter("garmentName", name);
		
		List<Educator> result = query.getResultList();

		return result;
	}

}
