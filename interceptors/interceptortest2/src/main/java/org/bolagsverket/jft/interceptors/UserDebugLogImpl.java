package org.bolagsverket.jft.interceptors;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpSession;

@UserDebugLog
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 100)
public class UserDebugLogImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String debugUserName;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		boolean debug = checkIfDebug();
		long time = 0;
		if (debug) {
			time = System.currentTimeMillis();
			System.out.println("Invoking " + ic.getTarget().getClass() + ":" + ic.getMethod().getName());
		}
		Object proceed = ic.proceed();
		if (debug) {
			long time2 = System.currentTimeMillis();
			System.out.println("Invoked " + ic.getTarget().getClass() + ":" + ic.getMethod().getName() +"("+(time2-time)+" ms)");
		}
		return proceed;
	}
	
	private boolean checkIfDebug(){
		boolean debug = false;
		if (debugUserName != null) {
			FacesContext currentInstance = FacesContext.getCurrentInstance();
			if (currentInstance != null) {
				ExternalContext externalContext = currentInstance.getExternalContext();
				if (externalContext != null) {
					HttpSession session = (HttpSession) externalContext.getSession(false);
					if (session != null) {
						String userName = (String) session.getAttribute("USER_NAME");
						if (userName != null) {
							if (userName.equals(debugUserName)) {
								debug = true;
							}
						}
					}
				}
			}
		}
		return debug;
	}
}
