package org.bolagsverket.jft.ejb;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.bolagsverket.jft.interceptors.LifecycleLogging;
import org.bolagsverket.jft.interceptors.TestEJBInterceptor;

@Stateless
@LifecycleLogging
@Interceptors(TestEJBInterceptor.class)
public class TestEJB {

	public void f() {
		int i = 0;
	}

}
