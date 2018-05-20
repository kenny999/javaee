package com.userdebuglog;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import interceptors.UserDebugLog;

@Stateless
@UserDebugLog
public class PlusEJB {
	public Integer plus(Integer varde1, Integer varde2) {
		return varde1 + varde2;
	}

	public List<Integer> plus(List<String> lista) {
		Integer result = Integer.valueOf(0);
		for(String s : lista){
			result = result + Integer.parseInt(s);
		}
		List<Integer> rList = new ArrayList<>();
		rList.add(result);
		return rList;
	}
}
