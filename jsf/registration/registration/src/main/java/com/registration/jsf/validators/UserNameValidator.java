package com.registration.jsf.validators;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.registration.ejb.SearchEJB;
import com.registration.jsf.beans.ConstantsBean;

@Named
@RequestScoped
public class UserNameValidator implements Validator, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3180706165257671631L;
	@Inject
	private ResourceBundle bundle;
	@Inject
	private ConstantsBean constantsBean;
	@EJB
	private SearchEJB searchEjb;

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String s = (String) value;
		if (s == null || s.length() < constantsBean.getUserNameMinLength()
				|| s.length() > constantsBean.getUserNameMaxLength()) {
			String msg = bundle.getString("error.userNameWrongLength");
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
		}
		boolean exists = false;
		try {
			exists = searchEjb.doesUserExist(s);
		} catch (Exception e) {
			String msg = bundle.getString("error.unknown");
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
		}
		if (exists) {
			String msg = bundle.getString("error.userNameAlreadyExists");
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
		}
	}

}
