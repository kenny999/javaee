package com.jsflabbing;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator{

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	    UIInput otherInput = (UIInput) context.getViewRoot().findComponent("myForm:password");
	    String otherValue = (String) otherInput.getValue();	
	    String svalue = (String) value;
	    if(svalue.equals(otherValue)){
	    	
	    } else {
			FacesMessage msg = new FacesMessage(null, "Passwords must match");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	    	throw new ValidatorException(msg);
	    }
	}

}
