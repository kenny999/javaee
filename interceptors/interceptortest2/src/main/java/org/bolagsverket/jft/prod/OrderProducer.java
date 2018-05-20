package org.bolagsverket.jft.prod;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.bolagsverket.jft.ejb.DependentEJB;

@ApplicationScoped
public class OrderProducer {
	
	@Inject DependentEJB e;


	@Produces
	@RequestScoped
	@NewOrder
	public Order getOrder2(){
		return new Order();
	}
	
	@Produces
	@Dependent
	@SelectedOrder
	public Order getOrder(@NewOrder Order o){
		return o;
	}
	
	public void disp(@Disposes @SelectedOrder Order o){
		int i = 0;
		
	}
	
	public void disp2(@Disposes @NewOrder Order o){
		int i = 0;
		
	}
}


