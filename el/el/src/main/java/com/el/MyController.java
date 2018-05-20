package com.el;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("ctrl")
@ViewScoped
public class MyController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<String> getAllstrings() {
		return allstrings;
	}

	public void setAllstrings(List<String> allstrings) {
		this.allstrings = allstrings;
	}

	public Cards getCard() {
		return card;
	}

	public void setCard(Cards card) {
		this.card = card;
	}

	private String propertyKalle = "Kalle";
	private Integer propertyOlle = Integer.valueOf(8);
	private String nullProperty;
	private String emptyStringProperty = "";
	private Cards card = Cards.SPADES;
	private List<String> allstrings;
	

	@PostConstruct
	public void init() {
		allstrings = new ArrayList<>();
		allstrings.add("SPADES");
		allstrings.add("DIAMONDS");
	}

	public String getEmptyStringProperty() {
		return emptyStringProperty;
	}

	public void setEmptyStringProperty(String emptyStringProperty) {
		this.emptyStringProperty = emptyStringProperty;
	}

	public String getNullProperty() {
		return nullProperty;
	}

	public void setNullProperty(String nullProperty) {
		this.nullProperty = nullProperty;
	}

	public Integer getPropertyOlle() {
		return propertyOlle;
	}

	public void setPropertyOlle(Integer propertyOlle) {
		this.propertyOlle = propertyOlle;
	}

	public String getPropertyKalle() {
		return propertyKalle;
	}

	public void setPropertyKalle(String propertyKalle) {
		this.propertyKalle = propertyKalle;
	}
}
