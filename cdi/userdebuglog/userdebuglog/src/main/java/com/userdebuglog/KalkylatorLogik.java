package com.userdebuglog;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import interceptors.UserDebugLog;

@UserDebugLog
@Dependent
public class KalkylatorLogik implements Serializable {

	@Inject
	PlusEJB plusEJB;
	
	@Inject
	MinusEJB minusEJB;
	
	@Inject
	TimesEJB timesEJB;
	
	@Inject
	DivideEJB divideEJB;
	
	public Integer times(Integer varde1, Integer varde2) {
		return timesEJB.times(varde1, varde2);
	}

	public Integer minus(Integer varde1, Integer varde2) {
		return minusEJB.minus(varde1, varde2);
	}

	public Integer plus(Integer varde1, Integer varde2) {
		return plusEJB.plus(varde1, varde2);
	}

	public Integer divide(Integer varde1, Integer varde2) {
		return divideEJB.divide(varde1, varde2);
	}

	private static final long serialVersionUID = 1L;

	public Integer plus(List<String> lista) {
		List<Integer> resultList = plusEJB.plus(lista);
		return resultList.get(0);
	}

	public Integer minus(List<String> lista) {
		List<Integer> resultList = minusEJB.minus(lista);
		return resultList.get(0);
	}

	public Integer divide(List<String> lista) {
		List<Integer> resultList = divideEJB.divide(lista);
		return resultList.get(0);
	}

	public Integer times(List<String> lista) {
		List<Integer> resultList = timesEJB.times(lista);
		return resultList.get(0);
	}

}
