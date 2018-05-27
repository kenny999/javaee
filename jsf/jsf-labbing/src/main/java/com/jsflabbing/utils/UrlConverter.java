package com.jsflabbing.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("urlConverter")
public class UrlConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		String url = (String) value;

		UrlData urlData = new UrlData(url.toString());
		return urlData;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		UrlData urlData = (UrlData) value;
		return urlData.getUrl();
	}
}