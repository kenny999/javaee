package org.bolagsverket.jft.conv;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@ConversationScoped
@Named
public class TvChannelBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vendor;
	private String favoriteProgram;
	@Inject
	private Conversation conversation;
	@Inject HelperBean hb;
	private boolean done;
	private String timezone;

	
	@PostConstruct
	public void init(){
		System.out.println("PC "+getClass().getSimpleName());
		hb.setInitiator("TvChannelBean");
	}
	
	public void initConversation(){
	    if (!FacesContext.getCurrentInstance().isPostback() && conversation.isTransient()) {
	          conversation.begin();
	    }
	}

	

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public String next(){
		return "tvchannel2.xhtml?faces-redirect=true";
	}

	public String next2(){
		return "tvchannel3.xhtml?faces-redirect=true";
	}
	
	public String finalSubmit(){
		setDone(true);
		conversation.end();
		return null;
	}
	
	public String toString(){
		return "" + 
				"vendor:"+vendor +", "+
				"favoriteProgram:"+favoriteProgram +", "+
				"timezone:"+timezone +", "+
				"hb.getText():" + hb.getText()+", "+
				"hb.getInitiator():" + hb.getInitiator()+", "+
				"conversation.getId():" + conversation.getId()+", "+
				"conversation.isTransient():"+conversation.isTransient();
	}

	public String getCid() {
		return conversation.getId();
	}

	public String getFavoriteProgram() {
		return favoriteProgram;
	}

	public void setFavoriteProgram(String favoriteProgram) {
		this.favoriteProgram = favoriteProgram;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
}
