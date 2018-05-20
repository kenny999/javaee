package com.shoecdi;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.shoecdi.persistence.ShoeOwner;
import com.shoecdi.qualifiers.NumberOfRandomShoes;
import com.shoecdi.qualifiers.RandomShoeowner;
import com.shoecdi.qualifiers.ShoeDatabase;

@SessionScoped
public class ShoeService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@ShoeDatabase
	EntityManager em;

	@Inject
	@RandomShoeowner
	Instance<ShoeOwner> shoeOwnerSource;

	@Inject
	@NumberOfRandomShoes
	Integer numRandomShoes;

	@Transactional
	public void createRandomShoeOwner() {
		for (int i = 0; i < numRandomShoes; i++) {
			ShoeOwner shoeOwner = shoeOwnerSource.get();
			em.persist(shoeOwner);
			this.shoeOwnerSource.destroy(shoeOwner);
		}
	}
	
	@PostConstruct
	public void init(){
		int i = 0;
	}
}
