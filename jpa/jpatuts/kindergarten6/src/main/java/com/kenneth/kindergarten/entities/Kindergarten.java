package com.kenneth.kindergarten.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Kindergarten {

	private Long id;
	
	private Collection<Section> sections;
	
	private String name;

	@Id
	@SequenceGenerator(name="Kindergarten_Gen", sequenceName="Kindergarten_Seq", allocationSize=1)
	@GeneratedValue(generator="Kindergarten_Gen")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy="kindergarten", cascade=CascadeType.PERSIST)
	public Collection<Section> getSections() {
		return sections;
	}

	public void setSections(Collection<Section> sections) {
		this.sections = sections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
