package com.kenneth;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String path = context.getContextPath();
		Set<SessionTrackingMode> modes = context.getDefaultSessionTrackingModes();
		for(SessionTrackingMode mode : modes){
			int j = 0;
		}
		Set<SessionTrackingMode> effectiveModes = context.getEffectiveSessionTrackingModes();
		for(SessionTrackingMode mode : effectiveModes){
			int j = 0;
		}
		String serverInfo = context.getServerInfo();
		String vServerName = context.getVirtualServerName();
		SessionCookieConfig scc = context.getSessionCookieConfig();
		
		int i = 0;
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		int i = 0;
	}

}
