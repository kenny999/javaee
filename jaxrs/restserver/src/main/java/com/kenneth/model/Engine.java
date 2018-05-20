package com.kenneth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Engine {
	
	private String kind;
	private Long temperature;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Long getTemperature() {
		return temperature;
	}
	public void setTemperature(Long temperature) {
		this.temperature = temperature;
	}

}
