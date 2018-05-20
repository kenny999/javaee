package org.bolagsverket.jft.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class TestEJBInterceptor {
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		System.out.println("TestEJBInterceptor: Invoking " + ic.getTarget().getClass() + ":" + ic.getMethod().getName());
		return ic.proceed();
	}
}
