package com.wsusertrace;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.wsusertrace.persistence.VerkligHuvudman;
import com.wsusertrace.qualifiers.HuvudmanDatabase;

@SessionScoped
public class HuvudmanService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	@HuvudmanDatabase
	private EntityManager em;

	@Transactional
	public void create(VerkligHuvudman huvudman) {
		em.persist(huvudman);
	}

	@SuppressWarnings("unchecked")
	public List<VerkligHuvudman> sok(String orgnummer) {
		Query q = em.createQuery("select hm from VerkligHuvudman hm where hm.orgnummer = :orgnr");
		q.setParameter("orgnr", orgnummer);
		return (List<VerkligHuvudman>) q.getResultList();
	}

}
