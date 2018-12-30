package com.kenneth.exampleproj;

public class StringHelper {

	public static String strMinusLastChar(String s){
		if(s == null || s.isEmpty()){
			return s;
		}
		return s.substring(0, s.length()-1);
	}
}
