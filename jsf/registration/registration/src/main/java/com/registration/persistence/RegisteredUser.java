package com.registration.persistence;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.registration.jsf.beans.ConstantsBean;

@Entity
@NamedQueries({
		@NamedQuery(name = RegisteredUser.FIND_USER_BY_USERNAMEPREFIX, query = "SELECT r FROM RegisteredUser r WHERE r.userName LIKE :"
				+ RegisteredUser.PARAMETER_USER_FIND_USER_BY_USERNAMEPREFIX),
		@NamedQuery(name = RegisteredUser.FIND_USER_BY_USERNAME_EXACT, query = "SELECT r FROM RegisteredUser r WHERE r.userName = :"
				+ RegisteredUser.PARAMETER_USER_FIND_USER_BY_USERNAME_EXACT) })
public class RegisteredUser {
	public final static String FIND_USER_BY_USERNAMEPREFIX = "FIND_USER_BY_USERNAMEPREFIX";
	public final static String PARAMETER_USER_FIND_USER_BY_USERNAMEPREFIX = "userNamePrefix";
	public final static String FIND_USER_BY_USERNAME_EXACT = "FIND_USER_BY_USERNAME_EXACT";
	public final static String PARAMETER_USER_FIND_USER_BY_USERNAME_EXACT = "userName";
	@NotNull
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reguser_seq")
	@SequenceGenerator(name = "reguser_seq", sequenceName = "reguser_seq")
	private Integer Id;
	@NotNull
	@Size(min = ConstantsBean.userNameMinLength, max = ConstantsBean.userNameMaxLength)
	private String userName;
	private LocalDate birthDate;
	private String homePage;
	@NotNull
	private String email;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}