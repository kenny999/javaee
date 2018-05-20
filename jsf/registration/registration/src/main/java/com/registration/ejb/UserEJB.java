package com.registration.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.registration.persistence.RegisteredUser;

@Stateless
public class UserEJB {
	@PersistenceContext
	private EntityManager em;

	public void saveNewUser(RegisteredUser registeredUser) {
		em.persist(registeredUser);
	}
}