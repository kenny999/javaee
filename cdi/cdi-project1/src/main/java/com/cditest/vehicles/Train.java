package com.cditest.vehicles;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;

@ViewScoped
public class Train implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

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