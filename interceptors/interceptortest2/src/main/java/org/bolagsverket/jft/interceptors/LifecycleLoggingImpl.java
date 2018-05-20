package org.bolagsverket.jft.interceptors;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@LifecycleLogging
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 100)
public class LifecycleLoggingImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@AroundConstruct
	public Object aroundConstruct(InvocationContext ic) throws Exception {
		Object pr = ic.proceed();
		System.out.println("Constructed " + ic.getTarget().getClass().getName());		
		return pr;		
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		System.out.println("Invoking " + ic.getTarget().getClass() + ":" + ic.getMethod().getName());
		return ic.proceed();
	}

	@PostConstruct
	public Object postConstruct(InvocationContext ic) throws Exception {
		System.out.println("PostConstruct " + ic.getTarget().getClass());
		return ic.proceed();
	}

	@PreDestroy
	public Object preDestroy(InvocationContext ic) throws Exception {
		Object pr = ic.proceed();
		System.out.println("PreDestroy " + ic.getTarget().getClass().getName());
		return pr;
	}
}
