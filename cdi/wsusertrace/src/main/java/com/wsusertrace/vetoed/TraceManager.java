package com.wsusertrace.vetoed;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.wsusertrace.TraceConfig;

@ApplicationScoped
public class TraceManager {

	private List<TraceConfig> traceConfigs = new ArrayList<>();

	public void addTrace(TraceConfig traceConfig) {
		traceConfigs.add(traceConfig);
	}

	public boolean traceActive(String kundnr) {
		if(kundnr == null){
			return false;
		}
		for(TraceConfig c : traceConfigs){
			if(c.getKundnr().equals(kundnr)){
				return true;
			}			
		}
		return false;
	}
}
