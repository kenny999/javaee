package com.beanval1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.beanval1.constraints.AccountBelongsToBank;
import com.beanval1.constraints.PersonExistsAndIsAlive;
import com.beanval1.constraints.StreetBelongsToCity;
import com.beanval1.constraints.UserValidationGroups;

@GroupSequence(value = { User.class, UserValidationGroups.Group1.class,UserValidationGroups.Group2.class, UserValidationGroups.Group3.class})
@PersonExistsAndIsAlive(groups = UserValidationGroups.Group1.class)
@StreetBelongsToCity(groups = UserValidationGroups.Group2.class)
@AccountBelongsToBank(groups = UserValidationGroups.Group3.class)
@SequenceGenerator(name = "User_seq", sequenceName = "User_seq")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_seq")
	private Integer id;
	
	@NotNull(groups = UserValidationGroups.Group1.class)
	@Size(min = 3, max = 8, groups = UserValidationGroups.Group1.class)
	private String firstName;

	@NotNull(groups = UserValidationGroups.Group1.class)
	@Size(min = 3, max = 10,groups = UserValidationGroups.Group1.class)
	private String lastName;
	
	@NotNull(groups = UserValidationGroups.Group1.class)
	@Size(min=10, max=10, groups = UserValidationGroups.Group1.class)
	private String socialSecurityNumber;

	@NotNull
	@Size(min = 2, max = 10, groups = UserValidationGroups.Group2.class)
	private String street;
	
	@NotNull
	@Size(min = 2, max = 20, groups = UserValidationGroups.Group2.class)
	private String city;

	@NotNull
	@Size(min = 5, max = 10, groups = UserValidationGroups.Group3.class)
	private String bank;
	
	@NotNull
	@Size(min = 12, max = 12, groups = UserValidationGroups.Group3.class)
	private String account;
	
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
