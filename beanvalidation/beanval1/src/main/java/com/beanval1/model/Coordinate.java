package com.beanval1.model;

import javax.validation.Valid;

import com.beanval1.constraints.MaxDistanceBetweenPoints;

@MaxDistanceBetweenPoints(100)
public class Coordinate {

	@Valid
	private Point p1 = new Point();
	
	@Valid
	private Point p2 = new Point();
	
	public Point getP1() {
		return p1;
	}
	public void setP1(Point p1) {
		this.p1 = p1;
	}
	public Point getP2() {
		return p2;
	}
	public void setP2(Point p2) {
		this.p2 = p2;
	}
}
