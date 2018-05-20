package org.bolagsverket.jft;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.bolagsverket.jft.ejb.DependentEJB;
import org.bolagsverket.jft.interceptors.LifecycleLogging;

@RequestScoped
@LifecycleLogging
public class MyRequestBean3 {
	
	public void bar(){
	}
	
	@PreDestroy
	public void pre(){
		int i = 0;
	}

}
