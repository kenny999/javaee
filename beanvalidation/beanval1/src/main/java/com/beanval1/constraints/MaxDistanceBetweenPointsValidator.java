package com.beanval1.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.beanval1.model.Coordinate;
import com.beanval1.model.Point;

public class MaxDistanceBetweenPointsValidator implements ConstraintValidator<MaxDistanceBetweenPoints, Coordinate> {

	private int max;

	@Override
	public void initialize(MaxDistanceBetweenPoints constraintAnnotation) {
		max = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(Coordinate value, ConstraintValidatorContext context) {

		Point p1 = value.getP1();
		Point p2 = value.getP2();
		if (p1 == null || p2 == null) {
			return true;
		}
		Integer x1 = p1.getX();
		Integer y1 = p1.getY();
		Integer x2 = p2.getX();
		Integer y2 = p2.getY();
		if (x1 == null || y1 == null || x2 == null || y2 == null) {
			return true;
		}

		//
		double dDist = Math.sqrt((double) (x2 - x1) * (x2 - x1) + (double) (y2 - y1) * (y2 - y1));
		int iDist = (int) dDist;
		return iDist < max;
	}

}
