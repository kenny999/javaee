package com.ca1;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
public class MyEJB2 implements SuperInterface {

	@Resource(mappedName = "java:comp/TransactionSynchronizationRegistry")
	TransactionSynchronizationRegistry superTransactionSynchronizationRegistry;

	@Override
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void f() {
		System.out.println("f:" + Util.transactionStatusToString(superTransactionSynchronizationRegistry.getTransactionStatus()));	
	}
}
