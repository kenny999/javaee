package com.kenneth.kindergarten.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Section {
	private Long id;

	private String name;

	@Id
	@SequenceGenerator(name="Section_Gen", sequenceName="Section_Seq", allocationSize=1)
	@GeneratedValue(generator="Section_Gen")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private Kindergarten kindergarten;

	@ManyToOne
	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
	
	private Collection<Child> childs;

	@OneToMany(mappedBy="section", cascade=CascadeType.PERSIST)
	public Collection<Child> getChilds() {
		return childs;
	}

	public void setChilds(Collection<Child> childs) {
		this.childs = childs;
	}
	
	private Collection<Educator> educators;

	@OneToMany(mappedBy="section")
	public Collection<Educator> getEducators() {
		return educators;
	}

	public void setEducators(Collection<Educator> educators) {
		this.educators = educators;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
