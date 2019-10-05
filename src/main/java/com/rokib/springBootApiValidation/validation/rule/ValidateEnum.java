package com.rokib.springBootApiValidation.validation.rule;


import com.rokib.springBootApiValidation.validation.impl.ValidateEnumImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValidateEnumImpl.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(RUNTIME)
public @interface ValidateEnum {

    Class<? extends Enum<?>> enumClass();

    String message() default "{Invalid Values}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
