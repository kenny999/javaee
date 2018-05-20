package com.kenneth;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestAttributeListener implements javax.servlet.ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		int i = 0;
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		int i = 0;
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		int i = 0;
	}

}
