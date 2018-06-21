package com.mybatch;

import java.io.Serializable;
import java.util.List;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.mybatch.upc.StringsInputSource;
import com.mybatch.upc.StringsOutputSource;
import com.mybatch.upc.StringsOutputSourceFinal;

@ViewScoped
@Named
public class BatchController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<String> getInput() {
		return input;
	}

	public void setInput(List<String> input) {
		this.input = input;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private List<String> output;
	private List<String> input;

	public List<String> getOutput() {
		return output;
	}

	public void setOutput(List<String> output) {
		this.output = output;
	}

	public void dojob() throws InterruptedException {
		StringsInputSource.reset();
		StringsOutputSource.reset();
		StringsOutputSourceFinal.reset();
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		long execID = jobOperator.start("touppercaseandbackwards", null);
		while (true) {
			JobExecution jobExecution = jobOperator.getJobExecution(execID);
			BatchStatus batchStatus = jobExecution.getBatchStatus();
			if (batchStatus.equals(BatchStatus.COMPLETED)) {
				break;
			} else {
				Thread.sleep(1000l);
			}
		}
		input = StringsInputSource.getList();
		output = StringsOutputSourceFinal.getOutput();

	}

}
