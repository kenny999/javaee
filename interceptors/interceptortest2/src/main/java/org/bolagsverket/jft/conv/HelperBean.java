package org.bolagsverket.jft.conv;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;

@ConversationScoped
public class HelperBean implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text = "Helper text";
	private String initiator;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@PostConstruct
	public void init(){
		System.out.println("PC "+getClass().getSimpleName());
	}
	@PreDestroy
	public void pd(){
		System.out.println("PD "+getClass().getSimpleName());
	}

	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
}
