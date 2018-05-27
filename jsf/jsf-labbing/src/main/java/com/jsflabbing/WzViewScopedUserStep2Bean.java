package com.jsflabbing;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsflabbing.utils.UserBean;

@ViewScoped
@Named
public class WzViewScopedUserStep2Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3215516730233892463L;
	@Inject UserBean userBean;
	
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public String nextFromStep2(){
		System.out.println(userBean.getUser().getFirstName()+" "+userBean.getUser().getLastName());
		System.out.println(userBean.getUser().getStreet()+" "+userBean.getUser().getHomeTown());
		return "wz_viewscoped_user_step3?faces-redirect=true";
		
	}
	

}
