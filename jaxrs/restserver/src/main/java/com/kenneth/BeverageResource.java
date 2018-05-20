package com.kenneth;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kenneth.model.Beverage;
import com.kenneth.model.Pub;

@Path("beverage/")
public class BeverageResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Pub g(Beverage b) {
		Pub pub = new Pub();
		pub.setName("Bishops");
		long now = System.currentTimeMillis();
		pub.setOpeningHours(new Date(now - 3600*1000));
		pub.setClosingHours(new Date(now + 3600*1000));
		pub.setAddress("Golvägen 12 A");
		return pub;
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Pub g2(Beverage b) {
		Pub pub = new Pub();
		pub.setName("Bishops");
		long now = System.currentTimeMillis();
		pub.setOpeningHours(new Date(now - 3600*1000));
		pub.setClosingHours(new Date(now + 3600*1000));
		pub.setAddress("Bredbyvägen 14 A");
		return pub;
	}
}
