package com.jsflabbing;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.jsflabbing.NameValidator")
public class NameValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		System.out.println("NameValidator validating " + value + " in phase" + context.getCurrentPhaseId());

		if (value != null) {
			String s = (String) value;
			if (s.length() < 2) {
				FacesMessage msg = new FacesMessage(null, "Too short");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		} else {
			FacesMessage msg = new FacesMessage(null, "Too short");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	}
}
