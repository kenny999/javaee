package com.jsflabbing;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsflabbing.utils.UserBean;

@ViewScoped
@Named
public class WzConditional implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3215516730233892463L;
	@Inject UserBean userBean;
	
	private int step = 1;
	private boolean finished;
	
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public void nextFromStep1(){
		step++;
		System.out.println(userBean.getUser().getFirstName()+" "+userBean.getUser().getLastName());
		System.out.println(userBean.getUser().getStreet()+" "+userBean.getUser().getHomeTown());		
	}
	
	

	public void nextFromStep2(){
		step++;
		System.out.println(userBean.getUser().getFirstName()+" "+userBean.getUser().getLastName());
		System.out.println(userBean.getUser().getStreet()+" "+userBean.getUser().getHomeTown());		
	}
	

	public boolean getFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public void finish(){
		finished = true;
		System.out.println(userBean.getUser().getFirstName()+" "+userBean.getUser().getLastName());
		System.out.println(userBean.getUser().getStreet()+" "+userBean.getUser().getHomeTown());		
	}
	
	

}
