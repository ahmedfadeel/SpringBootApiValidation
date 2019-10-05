package com.rokib.springBootApiValidation.validation.rule;



import com.rokib.springBootApiValidation.validation.impl.UpperCaseValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UpperCaseValidatorImpl.class)
public @interface UpperCaseValidator {

    String message() default "{Field Name Must Be in Uppercase Letter}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
