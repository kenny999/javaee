package com.cditest;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import animals.AnimalBase;
import animals.Bird;
import annotations.Qualifier1;

@ViewScoped
@Named
public class TestOfQualifiersAndProducers implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	int numberPageViews = 0;
	@Inject Bird bird;
	@Inject @Qualifier1 AnimalBase animalBase;
	
	public int getNumberPageViews() {
		return numberPageViews;
	}

	public void setNumberPageViews(int numberPageViews) {
		this.numberPageViews = numberPageViews;
	}

	@PostConstruct
	public void init() {
		// System.out.println("PostConstruct
		// "+this.getClass().getName()+":"+wall+":"+animalBase+":"+cow+":"+elk);
	}

	public void submit() {
		numberPageViews++;
		System.out.println(this.getClass().getName()+":"+animalBase.getA());

	}
}