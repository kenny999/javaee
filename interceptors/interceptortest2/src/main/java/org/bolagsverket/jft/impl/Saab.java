package org.bolagsverket.jft.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;

@ConversationScoped
public class Saab implements Serializable {
	

	private static final long serialVersionUID = -4447214444964594760L;
	private String name = "Saab";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@PostConstruct
	public void pc(){
		System.out.println(getClass().getSimpleName() + " destroyed");
	}
}
