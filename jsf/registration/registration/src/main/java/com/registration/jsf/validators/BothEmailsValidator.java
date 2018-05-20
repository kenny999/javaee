package com.registration.jsf.validators;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BothEmailsValidator implements Validator {
	@Inject
	private ResourceBundle bundle;

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		UIInput input1 = (UIInput) component.getAttributes().get("email1");
		UIInput input2 = (UIInput) component.getAttributes().get("email2");
		String value1 = (String) input1.getSubmittedValue();
		String value2 = (String) input2.getSubmittedValue();
		if (value1 != null && value2 != null && !value1.isEmpty() && !value2.isEmpty()) {
			if (!value1.equalsIgnoreCase(value2)) {
				String msg = bundle.getString("error.emailsNotEqual");
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
			}
		}
	}
}
