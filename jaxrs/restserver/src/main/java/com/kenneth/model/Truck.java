package com.kenneth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Truck {
	
	private String name;
	private Engine engine;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
