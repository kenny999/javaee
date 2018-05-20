package com.kenneth;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements javax.servlet.http.HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		int i = 0;
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		int i = 0;
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		int i = 0;
	}

}
