package com.wsusertrace;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.wsusertrace.persistence.VerkligHuvudman;

@RequestScoped
public class Foretagshamtare {
	
	@Inject
	HuvudmanService huvudmanService;

	public Utdata hamta(Indata indata) {
		List<VerkligHuvudman> list = huvudmanService.sok(indata.getOrgnummer());
		Utdata utdata = new Utdata();
		utdata.setHuvudman(list);
		return utdata;
	}

}
