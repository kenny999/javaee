package com.kenneth;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements javax.servlet.ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		int i = 0;
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		int i = 0;
	}

}
