package com.mybatch.upc;

import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named
public class UppercaseItemWriter implements ItemWriter {

	@Override
	public void open(Serializable checkpoint) throws Exception {
		int i = 0;	
	}

	@Override
	public void close() throws Exception {
		int i = 0;		
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		for(Object o : items){
			String s = (String) o;
			StringsOutputSource.store(s);
		}
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		int i = 0;
		return null;
	}

}
