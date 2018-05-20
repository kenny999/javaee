package org.bolagsverket.jft.impl;

import javax.ejb.Stateless;

import org.bolagsverket.jft.qualifiers.LowerBody;

@Stateless
@LowerBody
public class UnderPants implements Cloth {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3711574241192657046L;
	
	public String toString(){
		return getClass().getSimpleName();
	}

}
