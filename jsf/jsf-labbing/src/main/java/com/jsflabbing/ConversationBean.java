package com.jsflabbing;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsflabbing.utils.UserBean;

@ConversationScoped
@Named
public class ConversationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3215516730233892463L;
	@Inject
	UserBean userBean;
	
	@PostConstruct
	public void init(){
		System.out.println("Constructed");
		userBean.resetUser();
	}

	@Inject
	private Conversation conversation;
	
	public void initConversation(){
	    if (!FacesContext.getCurrentInstance().isPostback() && conversation.isTransient()) {
	          conversation.begin();
	    }
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String nextFromStep1(){
		System.out.println(userBean.getUser().getFirstName()+" "+userBean.getUser().getLastName());
		return "conversation_step2?faces-redirect=true";
	}
	
	public String nextFromStep2(){
		System.out.println(userBean.getUser().getFirstName()+" "+userBean.getUser().getLastName());
		System.out.println(userBean.getUser().getStreet()+" "+userBean.getUser().getHomeTown());
		return "conversation_step3?faces-redirect=true";
	}
	

	public boolean getFinished(){
		return conversation.isTransient();
	}
	
	public void finish(){
		conversation.end();
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
}


