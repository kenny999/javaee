package com.beanval1.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.beanval1.model.User;

@Stateless
public class UserEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void createUser(User user){
		em.persist(user);
	}

}
