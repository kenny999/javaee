package com.kenneth.gui;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@ViewScoped
public class AllTypesOfParamsController implements Serializable {

	private static final long serialVersionUID = 1L;


	public void submit() {
		Client client = ClientBuilder.newClient();
		Response response = null;
		try {
			response = client.target(new URI("http://localhost:8080/restserver/rest-prefix/params")).queryParam("queryParam", "valueOfQueryBaram").
					matrixParam("matrixPatrix", "valueOfMatrixPatrix")
					.request(MediaType.APPLICATION_JSON).
					header("headerPeader", "valueOfHeaderPeader").cookie("cookieBookie", "valueOfCookieBookie").
					get();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
