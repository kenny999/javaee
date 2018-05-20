package com.beanval1.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.beanval1.model.User;

public class PersonExistsAndIsAliveValidator implements ConstraintValidator<PersonExistsAndIsAlive, User> {

	@Override
	public void initialize(PersonExistsAndIsAlive constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		String s = value.getSocialSecurityNumber();
		if(s == null){
			return true;
		}
		int lastDigit = Integer.parseInt(s.substring(s.length() -1, s.length()));
		if(lastDigit % 2 == 1){
			return true;
		}
		return false;
	}

}
