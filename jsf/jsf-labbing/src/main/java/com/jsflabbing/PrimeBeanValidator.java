package com.jsflabbing;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrimeBeanValidator implements ConstraintValidator<IsPrime, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		for (int i = 2; i < value; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void initialize(IsPrime constraintAnnotation) {
		int i = 0;
	}

}
