package com.ca1;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
public class MyEJB extends SuperclassEJB {
	
	@Resource(mappedName = "java:comp/TransactionSynchronizationRegistry")
	TransactionSynchronizationRegistry superTransactionSynchronizationRegistry;

	public void bar() {
		System.out.println("bar:" + Util.transactionStatusToString(superTransactionSynchronizationRegistry.getTransactionStatus()));
	}


}
