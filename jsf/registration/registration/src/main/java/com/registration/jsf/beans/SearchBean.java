package com.registration.jsf.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.registration.ejb.SearchEJB;
import com.registration.persistence.RegisteredUser;

@ViewScoped
@Named
public class SearchBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 754405983114976211L;
	private String userName;
	private boolean searchDone;
	private List<RegisteredUser> searchResult;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getSearchDone() {
		return searchDone;
	}

	public void setSearchDone(boolean searchDone) {
		this.searchDone = searchDone;
	}

	public List<RegisteredUser> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<RegisteredUser> searchResult) {
		this.searchResult = searchResult;
	}

	@Inject
	private SearchEJB searchEJB;

	public void doSearch() {
		searchDone = true;
		searchResult = searchEJB.searchUserWithPrefix(userName);
	}

	public static String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}
}
