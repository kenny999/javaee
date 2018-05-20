package org.bolagsverket.jft;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.bolagsverket.jft.impl.Cloth;
import org.bolagsverket.jft.qualifiers.LowerBody;
import org.bolagsverket.jft.qualifiers.UpperBody;

@Named
@ViewScoped
public class ClothesGUI implements Serializable {
	
	@Inject
	@UpperBody Cloth upperBody;
	
	@Inject
	@LowerBody Cloth lowerBody;

	private String result;
	
	
	
	
	
	
	
	
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 
	 */
	public void submit(){
		result = upperBody.toString() + ":BAAAAAAAB:" + lowerBody.toString();
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1723460100964479566L;
	
}
