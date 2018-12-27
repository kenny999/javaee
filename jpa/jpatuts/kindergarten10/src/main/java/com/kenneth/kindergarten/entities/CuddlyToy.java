package com.kenneth.kindergarten.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CuddlyToy {
	
	private Long id;
	
	private String name;

	@Id
	@SequenceGenerator(name="CuddlyToy_Gen", sequenceName="CuddlyToy_Seq", allocationSize=1)
	@GeneratedValue(generator="CuddlyToy_Gen")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private Child child;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(mappedBy="cuddlyToy")
	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
}
