package com.registration.jsf.validators;

import java.time.LocalDate;
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
public class WholeBirthDayValidator implements Validator {
	@Inject
	private ResourceBundle bundle;

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		UIInput input1 = (UIInput) component.getAttributes().get("birthYear");
		UIInput input2 = (UIInput) component.getAttributes().get("birthMonth");
		UIInput input3 = (UIInput) component.getAttributes().get("birthDay");
		String value1 = (String) input1.getSubmittedValue();
		String value2 = (String) input2.getSubmittedValue();
		String value3 = (String) input3.getSubmittedValue();
		if (value1 != null && value2 != null && value3 != null &&
			!value1.isEmpty() && !value2.isEmpty() && ! value3.isEmpty()) {
			try {
				LocalDate.of(Integer.parseInt(value1), Integer.parseInt(value2), Integer.parseInt(value3));
			} catch (Exception e) {
				String msg = bundle.getString("error.wholeBirthDayDoesNotExist");
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
			}
		}
	}
}