package com.kenneth;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class MyHttpSessionListener implements javax.servlet.http.HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		int i = 0;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		int i = 0;
	}

}
