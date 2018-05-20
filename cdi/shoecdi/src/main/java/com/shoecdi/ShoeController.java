package com.shoecdi;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.shoecdi.qualifiers.NumberOfRandomShoes;

@Named
@ViewScoped
public class ShoeController implements Serializable {

	private static final long serialVersionUID = -9147717712554105460L;

	private int numRandomShoes = 1;
	
	@Inject KennethsRequestScoped k1;
	@Inject KennethsRequestScoped k2;
	
	

	@Produces
	@NumberOfRandomShoes
	public int getNumRandomShoes(KennethsRequestScoped k3) {
		return numRandomShoes;
	}

	public void setNumRandomShoes(int numRandomShoes) {
		this.numRandomShoes = numRandomShoes;
	}

	@Inject
	private ShoeService shoeService;

	public void createRandomShoes() {
		shoeService.createRandomShoeOwner();
	}
}
