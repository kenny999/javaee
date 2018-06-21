package com.mybatch.upc;

import java.util.List;

import javax.batch.api.Batchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named
public class BackwardsBatchlet implements Batchlet{

	@Override
	public String process() throws Exception {
		List<String> myInput = StringsOutputSource.getOutput();
		for(String s : myInput){
			StringsOutputSourceFinal.store(new StringBuilder(s).reverse().toString());
		}
		return "COMPLETED";
	}

	@Override
	public void stop() throws Exception {
		int i = 0;
	}

}
