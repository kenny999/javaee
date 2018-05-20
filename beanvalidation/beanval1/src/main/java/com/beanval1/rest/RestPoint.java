package com.beanval1.rest;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.metadata.ConstraintDescriptor;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.beanval1.model.Coordinate;
import com.beanval1.model.Point;

@RequestScoped
@Path("/point")
public class RestPoint {

	@Inject
	Validator v;

	@GET
	@Produces("text/html; charset=UTF-8")
	public String doGet(@QueryParam(value = "x1") Integer x1, @QueryParam(value = "y1") Integer y1,
			@QueryParam(value = "x2") Integer x2, @QueryParam(value = "y2") Integer y2) {

		Set<ConstraintViolation<Point>> b = v.validateValue(Point.class, "x", x1);
		if (!b.isEmpty()) {
			String total = "";
			for (ConstraintViolation<Point> c : b) {
				total += c.getMessage() + "<br/>";
			}			
			return "Felaktigt värde på x1! "+total;
		}
		b = v.validateValue(Point.class, "y", y1);
		if (!b.isEmpty()) {
			String total = "";
			for (ConstraintViolation<Point> c : b) {
				total += c.getMessage() + "<br/>";
			}
			return "Felaktigt värde på y1! "+total;
		}
		b = v.validateValue(Point.class, "x", x2);
		if (!b.isEmpty()) {
			String total = "";
			for (ConstraintViolation<Point> c : b) {
				total += c.getMessage() + "<br/>";
			}
			return "Felaktigt värde på x2! "+total;
		}
		b = v.validateValue(Point.class, "y", y2);
		if (!b.isEmpty()) {
			String total = "";
			for (ConstraintViolation<Point> c : b) {
				total += c.getMessage() + "<br/>";
			}
			return "Felaktigt värde på y2! "+total;
		}

		Point p1 = new Point();
		p1.setX(x1);
		p1.setY(y1);

		b = v.validate(p1);

		String total = "";
		for (ConstraintViolation<Point> c : b) {
			total += c.getMessage() + "<br/>";
		}
		if (!total.isEmpty()) {
			return total;
		}

		Point p2 = new Point();
		p2.setX(x2);
		p2.setY(y2);

		b = v.validate(p2);

		total = "";
		for (ConstraintViolation<Point> c : b) {
			total += c.getMessage() + "<br/>";
		}
		if (!total.isEmpty()) {
			return total;
		}

		Coordinate coordinate = new Coordinate();
		coordinate.setP1(p1);
		coordinate.setP2(p2);

		Set<ConstraintViolation<Coordinate>> a = v.validate(coordinate);

		total = "";

		for (ConstraintViolation<Coordinate> c : a) {
			total += c.getMessage() + "<br/>";
		}
		if (!total.isEmpty()) {
			return total;
		}

		return "hello";
	}

}
