package com.kenneth;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class MyHttpSessionIdListener implements javax.servlet.http.HttpSessionIdListener {

	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
		int i = 0;
	}

}
