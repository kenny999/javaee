package org.bolagsverket.jft.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Decorator @Priority(Interceptor.Priority.APPLICATION + 100)
public class BeanInterface1Decorator implements BeanInterface1 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject @Delegate
	BeanInterface1 beanDelegate;
	public String getIt() {
		String s = beanDelegate.getIt();
		return s + " decorated";
	}

	public Integer doubleIt(Integer i) {
		Integer i2 = beanDelegate.doubleIt(i);
		return 2 * i2;
	}

}
