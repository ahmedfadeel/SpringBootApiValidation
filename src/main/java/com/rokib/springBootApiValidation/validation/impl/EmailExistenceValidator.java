package com.rokib.springBootApiValidation.validation.impl;

import com.rokib.springBootApiValidation.persistence.repository.UserRepository;
import com.rokib.springBootApiValidation.validation.rule.NotExistingEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailExistenceValidator implements ConstraintValidator<NotExistingEmail, String> {

    @Autowired
    private UserRepository userRepository;

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param email   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !userRepository.existsByEmail(email);
    }
}
