package com.beanval1.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { MaxDistanceBetweenPointsValidatorRest.class })
@Documented
public @interface MaxDistanceBetweenPointsRest {
	
	int value();

    String message() default "{com.beanval1.MaxDistanceBetweenPoints.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}