package com.beanval1.jsf;

import java.io.Serializable;
import java.util.Set;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.beanval1.constraints.UserValidationGroups;
import com.beanval1.model.User;
import com.beanval1.service.UserEJB;
import com.beanval1.service.UserService;

@ConversationScoped
@Named
public class UserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user = new User();
	@Inject
	Conversation conversation;
	@Inject
	Validator validator;
	@Inject
	UserService userService;
	@Inject
	UserEJB userEJB;

	public void preRenderView() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public String next1() {
		Set<ConstraintViolation<User>> a = validator.validate(user, UserValidationGroups.Group1.class);
		for (ConstraintViolation<User> c : a) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(c.getMessage()));
		}
		if (a.isEmpty()) {
			return "user1.xhtml&faces-redirect=true";
		}
		return null;
	}

	public String next1NoValidation() {
		return "user1.xhtml&faces-redirect=true";
	}
	
	public String next2() {
		Set<ConstraintViolation<User>> a = validator.validate(user, UserValidationGroups.Group2.class);
		for (ConstraintViolation<User> c : a) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(c.getMessage()));
		}
		if (a.isEmpty()) {
			return "user2.xhtml&faces-redirect=true";
		}
		return null;
	}

	public String next2NoValidation() {
		return "user2.xhtml&faces-redirect=true";
	}
	
	public String last() {
		Set<ConstraintViolation<User>> a = validator.validate(user, UserValidationGroups.Group3.class);
		for (ConstraintViolation<User> c : a) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(c.getMessage()));
		}
		if (a.isEmpty()) {
			return "user3.xhtml&faces-redirect=true";
		}
		return null;
	}

	public String lastNoValidation() {
		return "user3.xhtml&faces-redirect=true";
	}
	
	public String finishCDI() {
		conversation.end();
		userService.createUser(user);
		return "user.xhtml&faces-redirect=true";
	}

	public String finishEJB() {
		conversation.end();
		userEJB.createUser(user);
		return "user.xhtml&faces-redirect=true";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
