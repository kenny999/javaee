package org.bolagsverket.jft.decorator;

import java.io.Serializable;

import javax.enterprise.context.Dependent;

@Dependent
public interface BeanInterface1 extends Serializable {
	
	public String getIt();
	
	public Integer doubleIt(Integer i);

}
