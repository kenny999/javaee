package com.mybatch.upc;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named
public class UppercaseItemProcessor implements ItemProcessor {

	@Override
	public Object processItem(Object item) throws Exception {
		String s = (String) item;
		return s.toUpperCase();
	}

}
