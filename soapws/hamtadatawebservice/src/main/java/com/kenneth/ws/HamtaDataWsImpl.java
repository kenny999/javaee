package com.kenneth.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.BindingType;

import com.kenneth.hamtadata.v1.HamtaData;
import com.kenneth.hamtadataresponse_v1_0.HamtaDataResponse;
import com.kenneth.hamtadataresponse_v1_0.HamtaDataResponse.ResponsePayload;

@WebService(targetNamespace = "http://www.kenneth.com/HamtaData/v1", name = "HamtaData", serviceName = "HamtaDataWs")
@XmlSeeAlso({com.kenneth.hamtadataresponse_v1_0.ObjectFactory.class, com.kenneth.hamtadatarequest_v1_0.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class HamtaDataWsImpl implements HamtaData {

    @WebMethod
    @WebResult(name = "HamtaDataResponse", targetNamespace = "http://www.kenneth.com/hamtadataresponse_v1_0", partName = "response")
    public com.kenneth.hamtadataresponse_v1_0.HamtaDataResponse hamtaData(
        @WebParam(partName = "request", name = "HamtaDataRequest", targetNamespace = "http://www.kenneth.com/hamtadatarequest_v1_0")
        com.kenneth.hamtadatarequest_v1_0.HamtaDataRequest request
    ){
    	String referens = request.getRequestPayload().getReferens();
    	String version = request.getRequestPayload().getVersion();
    	HamtaDataResponse hdr = new HamtaDataResponse();
    	ResponsePayload responsePayload = new ResponsePayload();
    	responsePayload.setData("data_"+referens+"_"+version);
    	responsePayload.setReferens(referens+"_A");
    	hdr.setResponsePayload(responsePayload);
		return hdr;
    	
    }
}