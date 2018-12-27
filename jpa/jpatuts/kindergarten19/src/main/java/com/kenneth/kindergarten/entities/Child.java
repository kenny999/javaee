package com.kenneth.kindergarten.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Child.findChildByName, query = "select c from Child c where c.name = :childName")
public class Child {
	
	public static final String findChildByName = "findChildByName";

	private Long id;
	
	private String name;

	@Id
	@SequenceGenerator(name="Child_Gen", sequenceName="Child_Seq", allocationSize=1)
	@GeneratedValue(generator="Child_Gen")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private Section section;

	@ManyToOne
	public Section getSection() {
		return section;
	}
	
	@OneToMany(mappedBy="child")
	public Collection<Garment> getGarments() {
		return garments;
	}

	public void setGarments(Collection<Garment> garments) {
		this.garments = garments;
	}

	private Collection<Garment> garments;

	public void setSection(Section section) {
		this.section = section;
	}
	
	private Educator educator;

	@ManyToOne
	public Educator getEducator() {
		return educator;
	}

	public void setEducator(Educator educator) {
		this.educator = educator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Collection<Toy> toys;

	@ManyToMany
	public Collection<Toy> getToys() {
		return toys;
	}

	public void setToys(Collection<Toy> toys) {
		this.toys = toys;
	}

}
