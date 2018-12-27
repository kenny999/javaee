package com.kenneth.kindergarten.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Garment {

	private Long id;

	private String name;

	@Id
	@SequenceGenerator(name="Garment_Gen", sequenceName="Garment_Seq", allocationSize=1)
	@GeneratedValue(generator="Garment_Gen")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private Child child;

	@ManyToOne
	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
