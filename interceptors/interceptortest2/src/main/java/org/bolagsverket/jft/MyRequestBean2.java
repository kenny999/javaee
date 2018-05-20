package org.bolagsverket.jft;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.bolagsverket.jft.ejb.DependentEJB;
import org.bolagsverket.jft.interceptors.LifecycleLogging;

@RequestScoped
@LifecycleLogging
public class MyRequestBean2 {
	
	@Inject DependentEJB e;
	public void bar(){
		e.foo();		
	}
	
	@PreDestroy
	public void pre(){
		int i = 0;
	}

}
