package com.wsusertrace;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wsusertrace.qualifiers.HuvudmanDatabase;

@Dependent
public class JavaEEProducer {
	
	@PersistenceContext
	EntityManager em;
	
	@Produces
	@SessionScoped
	@HuvudmanDatabase
	public  EntityManager getEntityManager(){
		return em;
	}

}
