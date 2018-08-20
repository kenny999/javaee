package com.ca1;

import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.TransactionSynchronizationRegistry;

@TransactionAttribute(TransactionAttributeType.NEVER)
public class SuperclassEJB {

	@Resource(mappedName = "java:comp/TransactionSynchronizationRegistry")
	TransactionSynchronizationRegistry superTransactionSynchronizationRegistry;

	public void foo() {
		System.out.println("foo: " + Util.transactionStatusToString(superTransactionSynchronizationRegistry.getTransactionStatus()));
	}

}
