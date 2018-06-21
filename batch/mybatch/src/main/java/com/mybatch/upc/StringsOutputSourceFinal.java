package com.mybatch.upc;

import java.util.ArrayList;
import java.util.List;

public class StringsOutputSourceFinal {
	
	private static List<String> output = new ArrayList<>();
	
	public static synchronized void store(String s){
		output.add(s);
	}

	public synchronized static List<String> getOutput() {
		return output;
	}

	public static synchronized void reset() {
		output = new ArrayList<>();		
	}

}
