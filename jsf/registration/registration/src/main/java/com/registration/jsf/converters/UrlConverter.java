package com.registration.jsf.converters;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import com.registration.util.UrlData;

@Named
@RequestScoped
public class UrlConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		UrlData urlData = new UrlData(value.toString());
		return urlData;
	}

	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		return value.toString();
	}
}