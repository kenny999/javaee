package com.kenneth.kindergarten.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Shelf {
	
	private Long id;
	
	private String position;

	@Id
	@SequenceGenerator(name="Shelf_Gen", sequenceName="Shelf_Seq", allocationSize=1)
	@GeneratedValue(generator="Shelf_Gen")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	private Child child;

	@OneToOne(mappedBy="shelf")
	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
}
