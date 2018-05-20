package com.kenneth.impl;

import javax.enterprise.context.RequestScoped;

import com.kenneth.TempRequestScoped;

@RequestScoped
public class TempRequestScopedImpl implements TempRequestScoped{
	
	public Integer getValue(){
		return 8;
	}

}
