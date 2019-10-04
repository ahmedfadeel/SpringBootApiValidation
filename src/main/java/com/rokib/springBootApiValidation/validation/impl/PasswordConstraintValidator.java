package com.rokib.springBootApiValidation.validation.impl;


import com.rokib.springBootApiValidation.validation.rule.ValidPassword;
import org.passay.*;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@Component
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        PasswordValidator validator =
                new PasswordValidator(
                        Arrays.asList(
                                new UppercaseCharacterRule(1),
                                new LowercaseCharacterRule(1),
                                new DigitCharacterRule(1),
                                new SpecialCharacterRule(1),
                                new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        context
                .buildConstraintViolationWithTemplate(
                        "Password should contain one uppercase letter, one lowercase letter,one digit, one special character and no whitespace")
                .addConstraintViolation();
        return false;
    }
}
