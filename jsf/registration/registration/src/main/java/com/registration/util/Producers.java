package com.registration.util;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@RequestScoped
public class Producers {
	@Produces
	public ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle("/com/registration/messages/msg");
	}
}