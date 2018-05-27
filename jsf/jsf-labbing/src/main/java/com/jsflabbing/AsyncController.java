package com.jsflabbing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AsyncController implements Serializable {
	
	@EJB
	CalcEJB calcEJB;

	@EJB
	CalcEJB calcEJB2;

	@EJB
	CalcEJB calcEJB3;

	@EJB
	CalcEJB calcEJB4;

	@EJB
	CalcEJB calcEJB5;

	final int max = 1521;

	public void sync(){
		System.out.println("SYNC START");
		List<Integer> numbers = getNumbers();
		
		List<Integer> results = new ArrayList<>();
		for(int i =0;i<max;i++){
			results.add(calcEJB.doubleIt(numbers.get(i)));
		}
		printSum(results);
	}

	public void async() throws InterruptedException, ExecutionException{
		System.out.println("ASYNC START");
		
		List<Integer> numbers = getNumbers();
		
		List<Integer> results = new ArrayList<>();
		
		int i=0;
		while(i<max){
			Future<Integer> doubleItAsync2 = null;
			Future<Integer> doubleItAsync3 = null;
			Future<Integer> doubleItAsync4 = null;
			Future<Integer> doubleItAsync5 = null;

			Future<Integer> doubleItAsync = calcEJB.doubleItAsync(numbers.get(i));
			i++;
			if(i<max){
				doubleItAsync2 = calcEJB2.doubleItAsync(numbers.get(i));
				i++;				
			}
			if(i<max){
				doubleItAsync3 = calcEJB3.doubleItAsync(numbers.get(i));
				i++;				
			}
			if(i<max){
				doubleItAsync4 = calcEJB4.doubleItAsync(numbers.get(i));
				i++;				
			}
			if(i<max){
				doubleItAsync5 = calcEJB5.doubleItAsync(numbers.get(i));
				i++;				
			}
			Integer e = doubleItAsync.get();
			results.add(e);
			if(doubleItAsync2 != null){
				e = doubleItAsync2.get();
				results.add(e);				
			}
			if(doubleItAsync3 != null){
				e = doubleItAsync3.get();
				results.add(e);
			}
			if(doubleItAsync4 != null){
				e = doubleItAsync4.get();
				results.add(e);				
			}
			if(doubleItAsync5 != null){
				e = doubleItAsync5.get();
				results.add(e);				
			}
		}
		printSum(results);
	}
	
	private void printSum(List<Integer> results) {
		int sum = 0;
		for(int i =0;i<max;i++){
			sum += results.get(i);
		}
		System.out.println(sum);
	}
	
	private List<Integer> getNumbers(){
		List<Integer> numbers = new ArrayList<>();
		for(int i =0;i<max;i++){
			numbers.add(3);
		}
		return numbers;
	}
}
