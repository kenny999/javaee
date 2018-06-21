package com.mybatch.upc;

import java.io.Serializable;

import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named
public class UppercaseItemReader implements ItemReader {

	@Override
	public void open(Serializable checkpoint) throws Exception {
		int i = 0;
	}

	@Override
	public void close() throws Exception {
		int i = 0;
	}

	@Override
	public Object readItem() throws Exception {
		return StringsInputSource.nextString();
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		int i = 0;
		return null;
	}
}
