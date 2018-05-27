package com.jsflabbing;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class FlashBean2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3297731050421267153L;

	public void check() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		String s1 = (String) flash.get("redirectMessage");
		String s2 = (String) flash.get("forwardMessage");
		System.out.println("redirectMessage:"+s1);
		System.out.println("forwardMessage:"+s2);
	}
}