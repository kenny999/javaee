package com.wsusertrace;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wsusertrace.vetoed.TraceManager;

@ViewScoped
@Named
public class AdminGUI implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6781537747914784244L;
	private TraceConfig traceConfig = new TraceConfig();
	
	@Inject TraceManager traceManager;
	public void trace(){
		traceManager.addTrace(traceConfig);		
	}

	public TraceConfig getTraceConfig() {
		return traceConfig;
	}

	public void setTraceConfig(TraceConfig traceConfig) {
		this.traceConfig = traceConfig;
	}
}
