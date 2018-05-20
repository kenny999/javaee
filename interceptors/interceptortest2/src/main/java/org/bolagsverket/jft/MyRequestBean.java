package org.bolagsverket.jft;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.bolagsverket.jft.ejb.DependentEJB;
import org.bolagsverket.jft.interceptors.LifecycleLogging;

@RequestScoped
@LifecycleLogging
public class MyRequestBean {
	
	@Inject DependentEJB e;
	
	@EJB
	DependentEJB e3;
	
	@Inject MyRequestBean2 e2;
	public void bar(){
		e.foo();
		e2.bar();
		e3.foo();
	}
	
	@PreDestroy
	public void pre(){
		int i = 0;
	}

}
