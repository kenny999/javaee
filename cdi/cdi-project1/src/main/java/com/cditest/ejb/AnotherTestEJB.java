package com.cditest.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cditest.vehicles.Plane;

@Stateless
public class AnotherTestEJB {

	@Inject Plane p;
	
	public void f(){
		p.getA();
	}
}
