package com.beanval1.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { PersonExistsAndIsAliveValidator.class })
@Documented
public @interface PersonExistsAndIsAlive {
	
    String message() default "{com.beanval1.PersonExistsAndIsAlive.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
