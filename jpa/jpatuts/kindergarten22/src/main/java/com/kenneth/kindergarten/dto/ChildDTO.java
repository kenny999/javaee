package com.kenneth.kindergarten.dto;

public class ChildDTO {
	
	private String name;
	private Long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ChildDTO(Long id, String name){
		this.id = id;
		this.name = name;
	}

}
