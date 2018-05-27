package com.jsflabbing;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsflabbing.utils.UserBean;

@ViewScoped
@Named
public class WzViewScopedUserStep1Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3215516730233892463L;
	@Inject UserBean userBean;
	
	@PostConstruct
	public void init(){
		userBean.resetUser();
	}
	
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public String nextFromStep1(){
		System.out.println(userBean.getUser().getFirstName()+" "+userBean.getUser().getLastName());
		return "wz_viewscoped_user_step2?faces-redirect=true";
	}
	

}
