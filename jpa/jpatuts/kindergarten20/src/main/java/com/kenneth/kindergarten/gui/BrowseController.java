package com.kenneth.kindergarten.gui;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kenneth.kindergarten.ejb.KindergartenBean;
import com.kenneth.kindergarten.entities.Child;

@Named
@ViewScoped
public class BrowseController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static final long PAGE_SIZE = 10;

	private Collection<Child> childList;
	
	public Collection<Child> getChildList() {
		return childList;
	}

	public void setChildList(Collection<Child> childList) {
		this.childList = childList;
	}

	private long numKids;
	private long currentPage;
	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public long getNumPages() {
		return numPages;
	}

	public void setNumPages(long numPages) {
		this.numPages = numPages;
	}

	private long numPages;
	
	@Inject
	KindergartenBean kindergartenBean;
	
	@PostConstruct
	public void init(){
		numKids = kindergartenBean.countNumberOfKids();
		currentPage = 1;
		numPages = (numKids / PAGE_SIZE) + (numKids % PAGE_SIZE > 0 ? 1 : 0);
		
		childList = kindergartenBean.getPageOfChilds(currentPage-1, PAGE_SIZE);
	}

	public long getNumKids() {
		return numKids;
	}

	public void setNumKids(long numKids) {
		this.numKids = numKids;
	}
	
	public void previous(){
		if(currentPage > 1){
			currentPage--;
			childList = kindergartenBean.getPageOfChilds(currentPage-1, PAGE_SIZE);
		}		
	}

	public void next(){
		if(currentPage < numPages){
			currentPage++;
			childList = kindergartenBean.getPageOfChilds(currentPage-1, PAGE_SIZE);
		}
	}
}
