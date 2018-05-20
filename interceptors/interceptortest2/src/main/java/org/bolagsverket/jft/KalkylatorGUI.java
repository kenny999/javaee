package org.bolagsverket.jft;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.bolagsverket.jft.decorator.BeanInterface1;
import org.bolagsverket.jft.ejb.DependentEJB;
import org.bolagsverket.jft.ejb.TestEJB;
import org.bolagsverket.jft.interceptors.LifecycleLogging;
import org.bolagsverket.jft.interceptors.UserDebugLog;
import org.bolagsverket.jft.prod.NewOrder;
import org.bolagsverket.jft.prod.Order;
import org.bolagsverket.jft.prod.SelectedOrder;

@Named
@ViewScoped
@UserDebugLog
public class KalkylatorGUI implements Serializable {

	private Integer varde1;
	private Integer varde2;
	private Integer result;
	
	private KalkylatorLogik kalkylatorLogik = new KalkylatorLogik();
	
	@Inject
	@NewOrder
	Order order;
	
	@Inject
	@SelectedOrder
	Order sorder;
	
	
	@EJB
	TestEJB e;
	
	@Inject
	DependentEJB e2;
	
	@Inject MyRequestBean rr;
	
	@Inject BeanInterface1 b;
	
	
	

	public void plus() {
		System.out.println("invoked plus");
		result = kalkylatorLogik.plus(varde1, varde2);
		
		e.f();
		e2.foo();
		rr.bar();
		
		Integer d = b.doubleIt(4);
		int i = 0;
		
		
	}

	public void minus() {
		result = kalkylatorLogik.minus(varde1, varde2);
	}

	public Integer getVarde1() {
		return varde1;
	}

	public void setVarde1(Integer varde1) {
		this.varde1 = varde1;
	}

	public Integer getVarde2() {
		return varde2;
	}

	public void setVarde2(Integer varde2) {
		this.varde2 = varde2;
	}

	public void times() {
		result = kalkylatorLogik.times(varde1, varde2);
	}

	public void divide() {
		result = kalkylatorLogik.divide(varde1, varde2);
	}
	
	public String gotouser(){
		return "user.xhtml";
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	private static final long serialVersionUID = 1L;

	@PreDestroy
public void pd(){
	
}

}
