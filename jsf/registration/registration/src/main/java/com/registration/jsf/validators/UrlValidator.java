package com.registration.jsf.validators;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.registration.util.UrlData;

@Named
@RequestScoped
public class UrlValidator implements Validator {
	@Inject
	private ResourceBundle bundle;

	public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
		UrlData d = (UrlData) o;
		String urlStr = d.getUrl();
		if (urlStr != null && !urlStr.isEmpty()) {
			if (!urlStr.startsWith("http://") && !urlStr.startsWith("https://")) {
				String msg = bundle.getString("error.homePageWrongFormat");
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
			}
		}
	}
}
