package com.ca1;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface SuperInterface {

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	void f();
}
