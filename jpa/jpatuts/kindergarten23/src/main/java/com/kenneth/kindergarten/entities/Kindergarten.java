package com.kenneth.kindergarten.entities;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
@NamedQuery(name = Kindergarten.findKindergartenByName, query = "select k from Kindergarten k "+
							"join fetch k.sections s "+
							"join fetch s.childs c "+
							"join fetch c.garments "+
							"where k.name = :kindergartenName")
})
public class Kindergarten {

	public static final String findKindergartenByName = "findKindergartenByName";

	private Long id;
	
	private Set<Section> sections;
	
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

	@OneToMany(mappedBy="kindergarten")
	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
