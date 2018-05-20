package org.bolagsverket.jft.impl;

import javax.enterprise.context.Dependent;

import org.bolagsverket.jft.qualifiers.UpperBody;

@Dependent
@UpperBody
public class Shirt implements Cloth {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6611732372106052849L;


	public String toString(){
		return getClass().getSimpleName();
	}

	
}
