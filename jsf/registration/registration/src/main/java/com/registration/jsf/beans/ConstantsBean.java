package com.registration.jsf.beans;

import java.time.Year;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class ConstantsBean {
	public static final int userNameMinLength = 3;

	public int getUserNameMinLength() {
		return userNameMinLength;
	}

	public int getUserNameMaxLength() {
		return userNameMaxLength;
	}

	public String getDefaultheaderSrc() {
		return defaultheaderSrc;
	}

	public String getMastertemplateSrc() {
		return mastertemplateSrc;
	}

	public static final int userNameMaxLength = 8;
	private String defaultheaderSrc = "/WEB-INF/templates/defaultheader.xhtml";
	private String mastertemplateSrc = "/WEB-INF/templates/mastertemplate.xhtml";

	public Integer getCurrentYear() {
		return Year.now().getValue();
	}
}