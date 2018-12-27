package com.kenneth.kindergarten.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Toy.findToyByName, query = "select t from Toy t where t.name = :toyName")
public class Toy {
	
	public static final String findToyByName = "findToyByName";

	private String name;

	private Long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@SequenceGenerator(name="Toy_Gen", sequenceName="Toy_Seq", allocationSize=1)
	@GeneratedValue(generator="Toy_Gen")	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private Collection<Child> childs;

	@ManyToMany(mappedBy="toys")
	public Collection<Child> getChilds() {
		return childs;
	}

	public void setChilds(Collection<Child> childs) {
		this.childs = childs;
	}

}
