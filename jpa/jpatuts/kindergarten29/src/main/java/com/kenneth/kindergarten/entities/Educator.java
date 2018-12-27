package com.kenneth.kindergarten.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Educator extends Person {

	private String name;

	private Section section;

	@ManyToOne
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	private Collection<Child> childs;

	@OneToMany(mappedBy="educator")
	public Collection<Child> getChilds() {
		return childs;
	}

	public void setChilds(Collection<Child> childs) {
		this.childs = childs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
