package org.bolagsverket.jft;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.bolagsverket.jft.impl.Saab;

@Named
@ConversationScoped
public class CarGUI implements Serializable {

	private static final long serialVersionUID = 3471676057622749661L;
	private String name = "volvo";

	@Inject
	Saab saab;

	@Inject
	Conversation conversation;

	@PostConstruct
	private void init() {
		name = "volvo" + saab.getName();

		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	
	public void submit(){
		
		int i = 0;
		saab.setName("Saaaaab");
		if (conversation.isTransient()) {
			conversation.begin();
			
		}
		String id = conversation.getId();
		int j = 0;
		
		
	}
	public void submit2(){
		
		if (! conversation.isTransient()) {
			conversation.end();
		}
		int j = 0;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
