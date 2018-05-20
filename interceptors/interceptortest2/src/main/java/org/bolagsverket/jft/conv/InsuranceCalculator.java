package org.bolagsverket.jft.conv;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

@ConversationScoped
public class InsuranceCalculator implements Serializable {
	
	private static final long serialVersionUID = -5027963369243069564L;
	private String totalPrice;
	
	@Inject HelperBean hb;
	@Inject InsuranceBean b;
	@Inject Conversation c;

	@PostConstruct
	public void init(){
		System.out.println("PC "+getClass().getSimpleName());
	}
	@PreDestroy
	public void pd(){
		System.out.println("PD "+getClass().getSimpleName());
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int calculate(){
		return Integer.parseInt(b.getPrice()) * Integer.parseInt(c.getId());
		
	}
	
	
}
