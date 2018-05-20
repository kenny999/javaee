package com.cditest.vehicles;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;

@Dependent
public class Car implements Serializable {
 static final long serialVersionUID = 1L;

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