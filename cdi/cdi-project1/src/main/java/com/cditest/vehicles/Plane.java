package com.cditest.vehicles;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Plane {
	@PostConstruct
	public void init() {
		System.out.println("PostConstruct " + this.getClass().getName());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroy " + this.getClass().getName());
	}
	public String getA() {
		return "a";
	}
}