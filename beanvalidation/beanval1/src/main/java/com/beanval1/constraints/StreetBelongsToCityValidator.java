package com.beanval1.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.beanval1.model.User;


public class StreetBelongsToCityValidator implements ConstraintValidator<StreetBelongsToCity, User> {

	@Override
	public void initialize(StreetBelongsToCity constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		
		String street = value.getStreet();
		String city = value.getCity();
		if(street == null | city == null){
			return false;
		}
		return street.substring(0,2).equals(city.substring(0,2));
	}


}
