package com.beanval1.jsf;

import java.io.Serializable;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.beanval1.model.Coordinate;

@ViewScoped
@Named
public class CreateController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Coordinate coordinate = new Coordinate();
	private Validator validator;
	
	@Inject
	public void setValidator(Validator validator){
		this.validator = validator;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public void create() {
		int i = 0;
	}

	public void check() {
		if (FacesContext.getCurrentInstance().isPostback()) {
			Set<ConstraintViolation<Coordinate>> a = validator.validate(coordinate);

			String total = "";

			for (ConstraintViolation<Coordinate> c : a) {
				total += c.getMessage() + "\n";
			}
			if (!total.isEmpty()) {
				coordinate = new Coordinate();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(total));
			}
		}
	}
}
