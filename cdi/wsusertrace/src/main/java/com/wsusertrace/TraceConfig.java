package com.wsusertrace;

public class TraceConfig {
	private String kundnr;
	public String getKundnr() {
		return kundnr;
	}
	public void setKundnr(String kundnr) {
		this.kundnr = kundnr;
	}
	public Integer getNumRequests() {
		return numRequests;
	}
	public void setNumRequests(Integer numRequests) {
		this.numRequests = numRequests;
	}
	private Integer numRequests;
}
