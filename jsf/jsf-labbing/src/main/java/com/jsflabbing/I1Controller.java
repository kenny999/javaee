package com.jsflabbing;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class I1Controller implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3967477877476194177L;

	@PostConstruct
	public void a(){
		
		System.out.println("PostConstruct");
	}
	
	public String next(){
		
		return "PAGE_1";
	}

	public String next2(){
		
		return "i3?faces-redirect=true";
	}
	
	public String next3(){
		
		return null;
	}
}
