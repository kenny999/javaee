
package com.shoecdi.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name =" SHOEOWNER")
@SequenceGenerator(name = "ShoeOwner_seq", sequenceName = "ShoeOwner_seq")
public class ShoeOwner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2035066090387063668L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ShoeOwner_seq")
	private Integer id;
	
	@OneToMany(mappedBy = "shoeOwner", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<ShoeBox> shoeBox;
	
	private String firstName;
	
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<ShoeBox> getShoeBox() {
		return shoeBox;
	}

	public void setShoeBox(Set<ShoeBox> shoeBox) {
		this.shoeBox = shoeBox;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void addShoeBox(ShoeBox shoeBox2) {
		if(shoeBox == null){
			shoeBox = new HashSet<ShoeBox>();
		}
		shoeBox.add(shoeBox2);
	}	
}
