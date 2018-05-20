package org.bolagsverket.jft.decorator;

import javax.enterprise.context.Dependent;

@Dependent
public class BeanImpl1 implements BeanInterface1 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getIt() {
		return "it";
	}

	public Integer doubleIt(Integer i) {
		return i * 2;
	}

}
