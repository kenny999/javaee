package org.bolagsverket.jft.conv;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class InsuranceBean implements Serializable {

	private static final long serialVersionUID = -5027963369243069564L;
	private String company;
	private String item;
	private String price;

	@Inject
	HelperBean hb;
	@Inject
	InsuranceCalculator ic;
	@Inject
	private Conversation conversation;
	private int result;
	private boolean done;

	@PostConstruct
	public void init() {
		System.out.println("PC " + getClass().getSimpleName());
		hb.setInitiator("InsuranceBean");
	}

	public void initConversation() {
		if (!FacesContext.getCurrentInstance().isPostback() && conversation.isTransient()) {
			conversation.begin();
		}
	}

	@PreDestroy
	public void pd() {
		System.out.println("PD " + getClass().getSimpleName());
	}

	public String stay() {
		return null;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String next() {
		return "insurances2.xhtml?faces-redirect=true";
	}

	public String next2() {
		return "insurances3.xhtml?faces-redirect=true";
	}

	public String finalSubmit() {
		setResult(ic.calculate());
		setDone(true);
		conversation.end();
		return null;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String toString() {
		return "" + 
				"company:"+company +", "+
				"item:"+item+", "+
				"price:"+price+", "+
				"hb.getText():" + hb.getText()+", "+
				"hb.getInitiator():" + hb.getInitiator()+", "+
				"conversation.getId():" + conversation.getId()+", "+
				"conversation.isTransient():"+conversation.isTransient();
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getCid() {
		return conversation.getId();
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
