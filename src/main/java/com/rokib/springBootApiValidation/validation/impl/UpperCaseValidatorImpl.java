package com.rokib.springBootApiValidation.validation.impl;


import com.rokib.springBootApiValidation.validation.rule.UpperCaseValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpperCaseValidatorImpl implements ConstraintValidator<UpperCaseValidator, String> {

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str == null) {
            return false;
        }
        return str.equals(str.toUpperCase());
    }
}