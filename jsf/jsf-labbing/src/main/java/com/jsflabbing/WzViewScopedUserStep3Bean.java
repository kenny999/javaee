package com.jsflabbing;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsflabbing.utils.UserBean;


@ViewScoped
@Named
public class WzViewScopedUserStep3Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3215516730233892463L;
	@Inject UserBean userBean;
	private boolean finished;
	
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public boolean getFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public void finish(){
		System.out.println(userBean.getUser().getFirstName()+" "+userBean.getUser().getLastName());
		System.out.println(userBean.getUser().getStreet()+" "+userBean.getUser().getHomeTown());
		System.out.println(userBean.getUser().getPhone()+" "+userBean.getUser().getTitle());
		finished = true;
	}
	

}
