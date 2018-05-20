package com.beanval1.rest;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.beanval1.model.Accountant;
import com.beanval1.model.Building;
import com.beanval1.model.Car;
import com.beanval1.model.Fish;
import com.beanval1.model.Hamburger;
import com.beanval1.model.Wall;
import com.beanval1.service.ExampleService;

@RequestScoped
@Path("/examples")
public class Examples {

	@Inject
	Validator v;

	@NotNull
	@Min(1)
	@Max(5)
	@QueryParam(value = "exampleid")
	Integer exampleid;

	@GET
	@Produces("text/html; charset=UTF-8")
	public String doGet() {

		if (exampleid.equals(1)) {
			exampleOfGroupInObjectGraph();
		} else if (exampleid.equals(2)) {
			exampleOfGroupRedefinition();
		} else if (exampleid.equals(3)) {
			exampleOfProgrammingByContract();
		} else if (exampleid.equals(4)) {
			exampleOfCrossParameterValidation();
		} else if (exampleid.equals(5)) {
			exampleOfMessageString();
		}

		return "hello";
	}

	private void exampleOfGroupInObjectGraph() {

		// Anta:
		// Om "left wall" är satt, måste "left wall" ha en färg.
		// De fält som ska valideras samtidigt tillhör "Group1".
		// Notera att i Building är övriga "walls" NULL men det blir inte
		// valideringsfel eftersom de grupperna inte valideras.

		Building building = new Building();
		Wall wall = new Wall();
		wall.setColor(1);
		building.setLeftWall(wall);

		Set<ConstraintViolation<Building>> constraints = v.validate(building, Examples.Group1.class);
		String total = "";
		if (!constraints.isEmpty()) {
			for (ConstraintViolation<Building> c : constraints) {
				total += c.getMessage() + "<br/>";
			}
		}
		int i = 0;

		// Skapar ett fall som inte validerar fallet ovan.
		building = new Building();
		wall = new Wall();
		wall.setColor(1);
		building.setRightWall(wall);

		constraints = v.validate(building, Examples.Group1.class);
		total = "";
		if (!constraints.isEmpty()) {
			for (ConstraintViolation<Building> c : constraints) {
				total += c.getMessage() + "<br/>";
			}
		}
		i = 0;
	}

	public interface Group1 {
	}

	public interface Group2 {
	}

	public interface Group3 {
	}

	public interface Group4 {
	}

	private void exampleOfGroupRedefinition() {

		// Anta att:
		// När vissa delar (=grupper) på Accountant är valid, ska vissa delar
		// (grupper)
		// på en Accountants Car vara valid.
		// En accountant måste ha ett hus samt en bilmodell.
		// Eller: När Group1 valideras på Accountant, ska Car.Group1 vara
		// "@Valid" på Car

		Accountant accountant = new Accountant();
		accountant.setHasHouse(true);
		Car car = new Car();
		car.setModel("subaru");
		accountant.setCar(car);

		// Se kod för Accountant, hur validering av Accountant.Group1.class
		// cascadar till Car.Group1.class
		Set<ConstraintViolation<Accountant>> constraints = v.validate(accountant, Accountant.Group1.class);
		String total = toMessage(constraints);
		int i = 0;

		// Skapar ett fall som inte validerar fallet ovan.
		// Eftersom Car har ingen "model" satt
		accountant = new Accountant();
		accountant.setHasHouse(true);
		car = new Car();
		car.setMotorIsBroken(true);
		accountant.setCar(car);

		constraints = v.validate(accountant, Accountant.Group1.class);
		total = toMessage(constraints);
		i = 0;

	}

	private String toMessage(Set<ConstraintViolation<Accountant>> constraints) {
		String total = "";
		if (!constraints.isEmpty()) {
			for (ConstraintViolation<?> c : constraints) {
				String whatFailed = "";
				javax.validation.Path p = c.getPropertyPath();
				for (Node n : p) {
					String s2 = n.getName();
					whatFailed += s2 + ".";
				}
				total += c.getMessage() + " " + whatFailed + "<br/>";

			}
		}
		return total;
	}

	@Inject
	private ExampleService exampleService;

	private void exampleOfProgrammingByContract() {

		// Först ett exempel på skapar non-valid Fish
		// (för hög "weight)

		String msg = "";
		try {
			Fish fish = exampleService.loadFish("abborre", 100);
		} catch (Exception e) {
			msg = e.getMessage();
		}
		int i = 0;

		// Se ett exempel på skapar valid Car

		msg = "";
		try {
			Fish fish = exampleService.loadFish("abborre", 8);
		} catch (Exception e) {
			msg = e.getMessage();
		}
		i = 0;
	}

	private void exampleOfCrossParameterValidation() {

		// Först ett validerande fall.

		Car car1 = new Car();
		car1.setModel("volvo");

		Car car2 = new Car();
		car2.setModel("volvo");

		exampleService.swapMotors(car1, car2);

		// Sen ett icke-validerande fall.

		car1 = new Car();
		car1.setModel("opel");

		car2 = new Car();
		car2.setModel("bmw");
		String msg = null;
		try {
			exampleService.swapMotors(car1, car2);
		} catch (ConstraintViolationException e) {
			msg = e.getMessage();
		}
		int i = 0;
	}


	private void exampleOfMessageString() {
		// Först ett validerande fall.

		Hamburger hamburger = new Hamburger();
		hamburger.setName("AJxUUjQ");

		Set<ConstraintViolation<Hamburger>> constraints = v.validate(hamburger);
		String total = "";
		if (!constraints.isEmpty()) {
			for (ConstraintViolation<Hamburger> c : constraints) {
				total += c.getMessage() + "<br/>";
			}
		}
		int i = 0;

		// Sen ett icke-validerande fall.

		hamburger = new Hamburger();
		hamburger.setName("AJxUUjQAAA");

		constraints = v.validate(hamburger);
		total = "";
		if (!constraints.isEmpty()) {
			for (ConstraintViolation<Hamburger> c : constraints) {
				total += c.getMessage() + "<br/>";
			}
		}
		i = 0;

		
		
	}


}
