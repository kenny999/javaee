package com.kenneth.app;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class MyController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	SessionScopedBean bean;
	public void touchSessionScopedBean(){
		bean.setCounter(bean.getCounter()+1);
		
	}

}
