package com.cditest;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cditest.vehicles.Bike;
import com.cditest.vehicles.Bus;
import com.cditest.vehicles.Car;
import com.cditest.vehicles.Plane;
import com.cditest.vehicles.Train;

import annotations.NotLoggedIn;

@ViewScoped
@Named
@NotLoggedIn
public class SimpleTestOfScopes implements Serializable {

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct " + this.getClass().getName());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroy " + this.getClass().getName());
	}
	public int getNumberPageViews() {
		return numberPageViews;
	}

	public void setNumberPageViews(int numberPageViews) {
		this.numberPageViews = numberPageViews;
	}

	private static final long serialVersionUID = -4728962828004824060L;
	int numberPageViews = 0;
	@Inject
	Car car1;
	@Inject
	Car car2;
	@Inject
	Bus bus1;
	@Inject
	Bus bus2;
	@Inject
	Train train1;
	@Inject
	Train train2;
	@Inject
	Plane plane1;
	@Inject
	Plane plane2;
	@Inject
	Bike bike1;
	@Inject
	Bike bike2;

	public void submit() {
		numberPageViews++;
		System.out.println("Entering " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(car1.getA());
		System.out.println(car2.getA());
		System.out.println(bus1.getA());
		System.out.println(bus2.getA());
		System.out.println(train1.getA());
		System.out.println(train2.getA());
		System.out.println(plane1.getA());
		System.out.println(plane2.getA());
		System.out.println(bike1.getA());
		System.out.println(bike2.getA());
	}
	
	public String helloworld(){
		return "helloworld?faces-redirect=true";
	}
}