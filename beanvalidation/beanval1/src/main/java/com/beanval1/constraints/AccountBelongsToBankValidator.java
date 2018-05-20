package com.beanval1.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.beanval1.model.User;

public class AccountBelongsToBankValidator implements ConstraintValidator<AccountBelongsToBank, User> {

	@Override
	public void initialize(AccountBelongsToBank constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		
		String bank = value.getBank();
		String account = value.getAccount();
		if(bank == null | account == null){
			return false;
		}
		if(bank.equals("SWEDBANK") && account.startsWith("1234")){
			return true;
		}
		if(bank.equals("NORDEA") && account.startsWith("2345")){
			return true;
		}
		return false;
	}

}
