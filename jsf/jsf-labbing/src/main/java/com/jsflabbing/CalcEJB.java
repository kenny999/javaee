package com.jsflabbing;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class CalcEJB {

	private void doSleep(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Integer doubleIt(Integer i){
		doSleep();
		return i * 2;
	}

	@Asynchronous
	public Future<Integer> doubleItAsync(Integer i){
		doSleep();		
		return new AsyncResult<Integer>(i*2);
	}
}
