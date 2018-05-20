package org.bolagsverket.jft.decorator;

public class BeanImpl2 implements BeanInterface2{

	public String getSome() {
		return "some";
	}

	public Integer tripleIt(Integer i) {
		return i * 3;
	}

}
