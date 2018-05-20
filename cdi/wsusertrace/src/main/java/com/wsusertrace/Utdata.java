package com.wsusertrace;

import java.util.List;

import com.wsusertrace.persistence.VerkligHuvudman;

public class Utdata {
	
	public List<VerkligHuvudman> getHuvudman() {
		return huvudman;
	}

	public void setHuvudman(List<VerkligHuvudman> huvudman) {
		this.huvudman = huvudman;
	}

	List<VerkligHuvudman> huvudman;

}
