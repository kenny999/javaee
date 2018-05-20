package com.beanval1.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class MixedCaseValidator implements ConstraintValidator<MixedCase, String> {
 private int numLowercase;
 private int numUppercase;
 public void initialize(MixedCase constraint) {
  numLowercase = constraint.numLowercase();
  numUppercase = constraint.numUppercase();
 }
 @Override
 public boolean isValid(String value, ConstraintValidatorContext context) {
  if(value == null) {
   return true;
  }
  int numUppercaseFound = 0;
  int numLowercaseFound = 0;
  
  for(int i = 0; i< value.length(); i++) {
   if(Character.isUpperCase(value.charAt(i))) {
    numUppercaseFound++;
   } else if(Character.isLowerCase(value.charAt(i))) {
    numLowercaseFound++;
   }   
  }
  return numUppercaseFound == numUppercase && numLowercaseFound == numLowercase;
 }
}

