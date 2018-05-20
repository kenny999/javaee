package com.kenneth;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("params/")
public class ParamsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void g(@QueryParam("queryParam") String queryParam,
			@CookieParam("cookieBookie") String cookieBookie,
			@MatrixParam("matrixPatrix") String matrixPatrix,
			@HeaderParam("headerPeader") String headerPeader) {
		int i = 0;
	}

}
