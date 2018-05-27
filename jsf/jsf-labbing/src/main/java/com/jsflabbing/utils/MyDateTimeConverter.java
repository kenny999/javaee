package com.jsflabbing.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("birthDateConverter")
public class MyDateTimeConverter extends DateTimeConverter {
	public MyDateTimeConverter() {
		setPattern("yyyy-MM-dd");
	}
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.length() != getPattern().length()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Invalid date format");
			facesContext.addMessage(null, facesMessage);
			throw new ConverterException("Invalid date format");
		}
		try {
		return super.getAsObject(context, component, value);
		} catch(Exception e){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("This is a message");
			facesContext.addMessage(null, facesMessage);
			throw e;
		}
	}
}
