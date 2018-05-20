package com.beanval1.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.beanval1.constraints.MaxDistanceBetweenPointsRest;

@RequestScoped
@Path("/point2")
@MaxDistanceBetweenPointsRest(value = 50)
public class RestPoint2 {

	@Inject
	Validator v;

	@NotNull
	@Min(value = -128, message = "{com.beanval1.xMin}")
	@Max(value = 128, message = "{com.beanval1.xMax}")
	@QueryParam(value = "x1") Integer x1;

	@NotNull
	@Min(value = -128, message = "{com.beanval1.xMin}")
	@Max(value = 128, message = "{com.beanval1.xMax}")
	@QueryParam(value = "y1") Integer y1;
	
	@NotNull
	@Min(value = -128, message = "{com.beanval1.xMin}")
	@Max(value = 128, message = "{com.beanval1.xMax}")
	@QueryParam(value = "x2") Integer x2;
	
	@NotNull
	@Min(value = -128, message = "{com.beanval1.xMin}")
	@Max(value = 128, message = "{com.beanval1.xMax}")
	@QueryParam(value = "y2") Integer y2;
	
	@GET
	@Produces("text/html; charset=UTF-8")
	public String doGet() {
		return "hello";
	}

	public Integer getX1() {
		return x1;
	}

	public void setX1(Integer x1) {
		this.x1 = x1;
	}

	public Integer getY1() {
		return y1;
	}

	public void setY1(Integer y1) {
		this.y1 = y1;
	}

	public Integer getX2() {
		return x2;
	}

	public void setX2(Integer x2) {
		this.x2 = x2;
	}

	public Integer getY2() {
		return y2;
	}

	public void setY2(Integer y2) {
		this.y2 = y2;
	}

	
}
