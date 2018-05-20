package com.kenneth;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public interface TempRequestScoped {
	
	public Integer getValue();

}
