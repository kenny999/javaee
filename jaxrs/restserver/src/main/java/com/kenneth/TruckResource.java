package com.kenneth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.kenneth.model.Engine;
import com.kenneth.model.Truck;

@Path("truck/")
public class TruckResource {
	
	@GET
	@Path("xml-return-entity")
	@Produces(MediaType.APPLICATION_XML)
	public Truck xmlReturnEntity(){
		return makeTruck();
	}

	@GET
	@Path("xml-return-response")
	@Produces(MediaType.APPLICATION_XML)
	public Response xmlReturnEesponse(){
		ResponseBuilder r = Response.ok(makeTruck());
		return r.build();
	}

	@GET
	@Path("json-return-entity")
	@Produces(MediaType.APPLICATION_JSON)
	public Truck jsonReturnEntity(){
		return makeTruck();
	}

	@GET
	@Path("json-return-response")
	@Produces(MediaType.APPLICATION_JSON)
	public Response jsonReturnResponse(){
		ResponseBuilder r = Response.ok(makeTruck());
		return r.build();	}
	
	private Truck makeTruck() {
		Truck t = new Truck();
		Engine e = new Engine();
		e.setKind("4TAKTS");
		e.setTemperature(100l);
		t.setEngine(e);
		t.setName("Volvo");
		return t;
	}
}
