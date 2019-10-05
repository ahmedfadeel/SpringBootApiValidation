package com.rokib.springBootApiValidation.validation.impl;


import com.rokib.springBootApiValidation.validation.rule.ValidateEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ValidateEnumImpl implements ConstraintValidator<ValidateEnum, String> {

    private List<String> valueList;

    @Override
    public void initialize(ValidateEnum constraintAnnotation) {
        valueList = new ArrayList<>();

        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();

        Enum[] enumValArr = enumClass.getEnumConstants();

        for (Enum enumVal : enumValArr) {
            valueList.add(enumVal.toString().toUpperCase());
        }
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s == null) {
            return false;
        }
        return valueList.contains(s);
    }
}