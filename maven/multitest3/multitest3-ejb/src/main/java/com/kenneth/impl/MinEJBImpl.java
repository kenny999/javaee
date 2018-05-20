package com.kenneth.impl;

import javax.ejb.Stateless;

import com.kenneth.MinEJB;

@Stateless
public class MinEJBImpl implements MinEJB {
	
	@Override
	public Integer addera(Integer i1, Integer i2){
		return i1+i2;
	}

}
