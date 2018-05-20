package com.beanval1.service;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.beanval1.model.User;

@RequestScoped
public class UserService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void createUser(@Valid User user){
		em.persist(user);
	}

}
