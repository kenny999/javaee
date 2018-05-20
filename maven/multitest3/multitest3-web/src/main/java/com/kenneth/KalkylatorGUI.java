package com.kenneth;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ViewScoped
public class KalkylatorGUI implements Serializable {

	private Integer varde1;
	private Integer varde2;
	private Integer result;
	
	@Inject
	TempRequestScoped t;

	@EJB
	MinEJB e;
	
	public void plus() {
		result = e.addera(varde1, varde2);
		result += t.getValue();
	}

	public void minus() {
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
	}

	public void divide() {
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	private static final long serialVersionUID = 1L;
}
