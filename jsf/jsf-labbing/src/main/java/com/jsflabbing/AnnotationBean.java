package com.jsflabbing;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class AnnotationBean implements Serializable {

	private static final long serialVersionUID = 8772785269650435669L;

	@Dependent
	public static class PrimeGenerator {
		private static Random rn = new Random();
		@Produces @PrimeNumber
		public Integer getOne(){
			int max = rn.nextInt(10000) + 1;
			for(int i=max;i>0;i++){
				if(isPrime(i)){
					return i;
				}
			}
			return 3;
		}
		private static boolean isPrime(int n) {
			for(int i=2;i<n;i++){
				if(n%i==0){
					return false;
				}
			}
			return true;
		}
	}

	@Inject @PrimeNumber
	Integer myNumber;
	
	@IsPrime
	private Integer theNumber;
	
	public Integer getTheNumber() {
		return theNumber;
	}

	public void setTheNumber(Integer theNumber) {
		this.theNumber = theNumber;
	}

	public void hello(){
		System.out.println(myNumber);
	}
}
