package com.kenneth.kindergarten.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class CuddlyToy {
	

	private Long id;
	
	private String name;
	
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Id
	@SequenceGenerator(name="CuddlyToy_Gen", sequenceName="CuddlyToy_Seq", allocationSize=1)
	@GeneratedValue(generator="CuddlyToy_Gen")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private Child child;

	@ManyToOne
	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
	
}
