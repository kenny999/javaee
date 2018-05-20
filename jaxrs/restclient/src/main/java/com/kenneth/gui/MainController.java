package com.kenneth.gui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MainController implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<String> availableTestCases;
	private String testCase;
	
	private static final String PATH_PARAM_BOOK = "Path param book";
	private static final String ALL_TYPES_OF_PARAMS = "All types of params";
	private static final String POST_BEVERAGE = "Post a beverage in JSON or XML";
	private static final String MATCH_RESOURCE_METHODS = "Enter params to match respurce methods";
	private static final String RESOURCE_METHOD_IMPL = "Testing different resource method implementations";
	
	
	@PostConstruct
	public void init(){
		availableTestCases = new ArrayList<>();
		availableTestCases.add("");
		availableTestCases.add(PATH_PARAM_BOOK);
		availableTestCases.add(ALL_TYPES_OF_PARAMS);
		availableTestCases.add(POST_BEVERAGE);
		availableTestCases.add(MATCH_RESOURCE_METHODS);
		availableTestCases.add(RESOURCE_METHOD_IMPL);
		
	}
	
	public void onChange(){
		if(testCase.equals(PATH_PARAM_BOOK)){
			redirect("pathparambook.xhtml");
		} else if(testCase.equals(ALL_TYPES_OF_PARAMS)){
			redirect("alltypesofparams.xhtml");		
		} else if(testCase.equals(POST_BEVERAGE)){
			redirect("postbeverage.xhtml");		
		}else if(testCase.equals(MATCH_RESOURCE_METHODS)){
			redirect("matchresourcemethods.xhtml");		
		}else if(testCase.equals(RESOURCE_METHOD_IMPL)){
			redirect("resourcemethodimpl.xhtml");		
		}
	}

	private void redirect(String path) {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
			ec.redirect(ec.getRequestContextPath() + "/" +path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public List<String> getAvailableTestCases() {
		return availableTestCases;
	}

	public void setAvailableTestCases(List<String> availableTestCases) {
		this.availableTestCases = availableTestCases;
	}

	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
}
