package com.kenneth;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kenneth.model.Car;
import com.kenneth.model.Garage;

@Path("car/")
public class CarResource {

	public Garage g(Car c) {
		Garage g = new Garage();
		g.setName("Garage 1 (from method g)");
		g.setNumberOfCars(1);
		g.setStreet("Garagevägen 3");
		return g;
	}

	@POST
	public Garage g2(Car c) {
		Garage g = new Garage();
		g.setName("Garage 5 (from method g2)");
		g.setNumberOfCars(2);
		g.setStreet("Hybrisvägen 3");
		return g;
	}

	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Garage g3(Car b) {
		Garage g = new Garage();
		g.setName("Garage 5 (from method g3)");
		g.setNumberOfCars(22);
		g.setStreet("Sockervägen 3");
		return g;
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Garage g4(Car b) {
		Garage g = new Garage();
		g.setName("Garage 51 (from method g4)");
		g.setNumberOfCars(221);
		g.setStreet("Strömmingsvägen 3");
		return g;
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Garage g5(Car b) {
		Garage g = new Garage();
		g.setName("Garage 5 (from method g5)");
		g.setNumberOfCars(22);
		g.setStreet("Saltvägen 3");
		return g;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Garage g6(Car b) {
		Garage g = new Garage();
		g.setName("Garage 51 (from method g6)");
		g.setNumberOfCars(11);
		g.setStreet("Blomvägen 3");
		return g;
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Garage g7(Car b) {
		Garage g = new Garage();
		g.setName("Garage 98 (from method g7)");
		g.setNumberOfCars(4);
		g.setStreet("Fiskvägen 3");
		return g;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Garage g8(Car b) {
		Garage g = new Garage();
		g.setName("Garage 76 (from method g8)");
		g.setNumberOfCars(8);
		g.setStreet("Djurvägen 3");
		return g;
	}


	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Garage g9(Car b) {
		Garage g = new Garage();
		g.setName("Garage 298 (from method g9)");
		g.setNumberOfCars(42);
		g.setStreet("Vägvägen 3");
		return g;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Garage g10(Car b) {
		Garage g = new Garage();
		g.setName("Garage 176 (from method g10)");
		g.setNumberOfCars(18);
		g.setStreet("Vinvägen 3");
		return g;
	}
}
