package com.beanval1.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({METHOD, CONSTRUCTOR })
@Retention(RUNTIME)
@Constraint(validatedBy = { CarsAreOfSameModelValidator.class })
@Documented
public @interface CarsAreOfSameModel {
	
    String message() default "{com.beanval1.constraints.CarsAreOfSameModel}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}