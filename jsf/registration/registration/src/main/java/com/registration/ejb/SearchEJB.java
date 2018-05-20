package com.registration.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.registration.persistence.RegisteredUser;

@Stateless
public class SearchEJB {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<RegisteredUser> searchUserWithPrefix(String userName) {
		Query q = em.createNamedQuery(RegisteredUser.FIND_USER_BY_USERNAMEPREFIX);
		q.setParameter(RegisteredUser.PARAMETER_USER_FIND_USER_BY_USERNAMEPREFIX, userName + "%");
		return (List<RegisteredUser>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public boolean doesUserExist(String userName) {
		Query q = em.createNamedQuery(RegisteredUser.FIND_USER_BY_USERNAME_EXACT);
		q.setParameter(RegisteredUser.PARAMETER_USER_FIND_USER_BY_USERNAME_EXACT, userName);
		Object r = null;
		try {
			r = q.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		return r != null;
	}
}
