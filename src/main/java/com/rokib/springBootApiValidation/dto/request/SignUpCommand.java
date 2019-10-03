package com.rokib.springBootApiValidation.dto.request;

import com.rokib.springBootApiValidation.constants.FieldConstraints;
import com.rokib.springBootApiValidation.validation.rule.NotExistingEmail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignUpCommand {

    @NotNull(message = "Email must not be null")
    @Email(message = "Must be a valid email")
    @NotExistingEmail
    @Size.List({
            @Size(
                    min = FieldConstraints.ForUser.MIN_EMAIL_LENGTH,
                    message = "Email must have at least {min} characters"),
            @Size(
                    max = FieldConstraints.ForUser.MAX_EMAIL_LENGTH,
                    message = "Email can have at most {max} characters")
    })
    @ApiModelProperty(
            notes =
                    "User's email, which does not exist already,length should be between ["
                            + FieldConstraints.ForUser.MIN_EMAIL_LENGTH
                            + ","
                            + FieldConstraints.ForUser.MAX_EMAIL_LENGTH
                            + "]",
            required = true)
    private String email;
    @NotEmpty(message = "User's First name must not be null or empty")
    @Size.List({
            @Size(
                    min = FieldConstraints.ForUser.MIN_FIRST_NAME_LENGTH,
                    message = "First name must have at least {min} characters"),
            @Size(
                    max = FieldConstraints.ForUser.MAX_FIRST_NAME_LENGTH,
                    message = "First name can have at most {max} characters")
    })
    @ApiModelProperty(
            notes =
                    "User's First name, length should be between ["
                            + FieldConstraints.ForUser.MIN_FIRST_NAME_LENGTH
                            + ","
                            + FieldConstraints.ForUser.MAX_FIRST_NAME_LENGTH
                            + "]",
            required = true)
    private String firstName;
    @Size.List({
            @Size(
                    min = FieldConstraints.ForUser.MIN_LAST_NAME_LENGTH,
                    message = "Last name name must have at least {min} characters"),
            @Size(
                    max = FieldConstraints.ForUser.MAX_LAST_NAME_LENGTH,
                    message = "Last name name can have at most {max} characters")
    })
    @ApiModelProperty(
            notes =
                    "User's Last name, length should be between ["
                            + FieldConstraints.ForUser.MIN_LAST_NAME_LENGTH
                            + ","
                            + FieldConstraints.ForUser.MAX_LAST_NAME_LENGTH
                            + "]")
    private String lastName;
}
