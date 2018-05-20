package org.bolagsverket.jft.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.bolagsverket.jft.MyRequestBean3;
import org.bolagsverket.jft.interceptors.LifecycleLogging;

@Stateless
@Dependent
@LifecycleLogging
public class DependentEJB {
	
	@Inject MyRequestBean3 bean3;
	public void foo(){
		int i = 0;
	}
	
	
	@PostConstruct
	public void post(){
		int i = 0;
	}

	@PreDestroy
	public void pre(){
		int i = 0;
	}

}
