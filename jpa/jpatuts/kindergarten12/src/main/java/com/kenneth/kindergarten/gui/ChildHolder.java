package com.kenneth.kindergarten.gui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.kenneth.kindergarten.entities.Child;

@SessionScoped
public class ChildHolder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Child child;

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
}
