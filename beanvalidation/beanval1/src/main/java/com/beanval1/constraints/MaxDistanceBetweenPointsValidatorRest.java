package com.beanval1.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.beanval1.rest.RestPoint2;

public class MaxDistanceBetweenPointsValidatorRest implements ConstraintValidator<MaxDistanceBetweenPointsRest, RestPoint2> {

	private int max;

	@Override
	public void initialize(MaxDistanceBetweenPointsRest constraintAnnotation) {
		max = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(RestPoint2 value, ConstraintValidatorContext context) {
		Integer x1 = value.getX1();
		Integer y1 = value.getY1();
		Integer x2 = value.getX2();
		Integer y2 = value.getY2();
		if (x1 == null || y1 == null || x2 == null || y2 == null) {
			return true;
		}
		//
		double dDist = Math.sqrt((double) (x2 - x1) * (x2 - x1) + (double) (y2 - y1) * (y2 - y1));
		int iDist = (int) dDist;
		return iDist < max;
	}

}
