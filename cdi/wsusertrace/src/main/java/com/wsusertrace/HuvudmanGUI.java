package com.wsusertrace;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wsusertrace.persistence.VerkligHuvudman;
import com.wsusertrace.vetoed.TraceManager;

@ViewScoped
@Named
public class HuvudmanGUI implements Serializable {
	

	private static final long serialVersionUID = -6781537747914784244L;
	private VerkligHuvudman huvudman = new VerkligHuvudman();
	public VerkligHuvudman getHuvudman() {
		return huvudman;
	}
	public void setHuvudman(VerkligHuvudman huvudman) {
		this.huvudman = huvudman;
	}
	
	@Inject HuvudmanService huvudmanService;
	
	public void create(){
		huvudmanService.create(huvudman);
		
	}
	
}
