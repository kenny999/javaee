package com.jsflabbing;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jsflabbing.utils.UrlData;

@ViewScoped
@Named
public class ConversionExampleBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8558894573824676703L;
	private Date birthDate;
	private Double employmentPercent;
	private UrlData url;

	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getEmploymentPercent() {
		return employmentPercent;
	}
	public void setEmploymentPercent(Double employmentPercent) {
		this.employmentPercent = employmentPercent;
	}
	public UrlData getUrl() {
		return url;
	}
	public void setUrl(UrlData url) {
		this.url = url;
	}
	
	public void submit(){
		int i =0;
		
	}
}
