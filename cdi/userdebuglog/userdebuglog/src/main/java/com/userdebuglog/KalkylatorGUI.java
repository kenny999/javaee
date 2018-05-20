package com.userdebuglog;

import java.io.Serializable;
import java.util.Arrays;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import interceptors.UserDebugLog;;

@Named
@ViewScoped
@UserDebugLog
public class KalkylatorGUI implements Serializable {

	private Integer varde1;
	private Integer varde2;
	private Integer result;
	private String lista;

	@Inject
	private KalkylatorLogik kalkylatorLogik;

	public void plus() {
		if (lista == null) {
			result = kalkylatorLogik.plus(varde1, varde2);
		} else {
			result = kalkylatorLogik.plus(Arrays.asList(lista.split("\\s+")));
		}
		reset();
	}

	public void minus() {
		if (lista == null) {
			result = kalkylatorLogik.minus(varde1, varde2);
		} else {
			result = kalkylatorLogik.minus(Arrays.asList(lista.split("\\s+")));
		}
		reset();
	}

	public void times() {
		if (lista == null) {
			result = kalkylatorLogik.times(varde1, varde2);
		} else {
			result = kalkylatorLogik.times(Arrays.asList(lista.split("\\s+")));
		}
		reset();
	}

	public void divide() {
		if (lista == null) {
			result = kalkylatorLogik.divide(varde1, varde2);
		} else {
			result = kalkylatorLogik.divide(Arrays.asList(lista.split("\\s+")));
		}
		reset();
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
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

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}

	private void reset() {
		lista = null;
		varde1 = null;
		varde2 = null;
	}

	private static final long serialVersionUID = 1L;

}
