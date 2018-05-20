package org.bolagsverket.jft;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class KalkylatorGUI implements Serializable {

	private Integer varde1;
	private Integer varde2;
	private Integer result;
	
	private KalkylatorLogik kalkylatorLogik = new KalkylatorLogik();

	public void plus() {
		result = kalkylatorLogik.plus(varde1, varde2);
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

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	private static final long serialVersionUID = 1L;
}
