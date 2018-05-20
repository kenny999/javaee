package org.bolagsverket.jft.conv;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Decorator
@Priority(Interceptor.Priority.APPLICATION + 100)
public class ConversationDecorator implements Conversation, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject @Delegate Conversation c;

	public void begin() {
		System.out.println(getClass().getSimpleName()+" begin");
		c.begin();		
	}

	public void begin(String id) {
		System.out.println(getClass().getSimpleName()+" begin-id");
		c.begin(id);	
	}

	public void end() {
		System.out.println(getClass().getSimpleName()+" end");
		c.end();
	}

	public String getId() {
		System.out.println(getClass().getSimpleName()+" getId");
		return c.getId();
	}

	public long getTimeout() {
		System.out.println(getClass().getSimpleName()+" getTimeout");
		return c.getTimeout();
	}

	public void setTimeout(long milliseconds) {
		System.out.println(getClass().getSimpleName()+" setTimeout");
		c.setTimeout(milliseconds);
	}

	public boolean isTransient() {
		System.out.println(getClass().getSimpleName()+" isTransient");
		return c.isTransient();	
	}

}
