package com.beanval1.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import com.beanval1.model.Car;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CarsAreOfSameModelValidator implements ConstraintValidator<CarsAreOfSameModel, Object[]> {

	@Override
	public void initialize(CarsAreOfSameModel constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object[] values, ConstraintValidatorContext context) {
		
		if(values == null){
			return true;
		}
		
		String model = null;
		boolean found = false;
		for(Object o : values){
			if(o instanceof Car){
				Car car = (Car) o;
				String m = car.getModel();
				if(! found){
					model = m;
					found = true;
				} else {
					if(model != null){
						if(! model.equals(m)){
							return false;
						}
					}
					
				}
			}
		}
		return true;
	}

}
