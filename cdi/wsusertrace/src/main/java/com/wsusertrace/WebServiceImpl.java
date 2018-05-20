package com.wsusertrace;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.wsusertrace.vetoed.CurrentCustomerExecution;

@WebService
public class WebServiceImpl {
	
	@Inject
	Foretagshamtare foretagshamtare;
	
	@Inject
	CurrentCustomerExecution currentCustomerExecution;

    @WebMethod(operationName = "hamtaForetagsinformation")
    public Utdata hamta(
        @WebParam(mode = WebParam.Mode.IN, name = "indata")
        Indata indata){
    	currentCustomerExecution.setKundnr(indata.getKundnummer());
    	return foretagshamtare.hamta(indata);
	}
	
}