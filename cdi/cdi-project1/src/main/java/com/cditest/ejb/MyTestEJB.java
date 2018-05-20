package com.cditest.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cditest.vehicles.Plane;

@Stateless
public class MyTestEJB {
	
	@Inject Plane p;
	@EJB AnotherTestEJB anotherTestEJB;
	
	public void f(){
		p.getA();
		anotherTestEJB.f();
	}

}
