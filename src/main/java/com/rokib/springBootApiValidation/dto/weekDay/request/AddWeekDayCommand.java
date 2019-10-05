package com.rokib.springBootApiValidation.dto.weekDay.request;

import com.rokib.springBootApiValidation.constants.FieldConstraints;
import com.rokib.springBootApiValidation.constants.WeekDayEnum;
import com.rokib.springBootApiValidation.validation.rule.UpperCaseValidator;
import com.rokib.springBootApiValidation.validation.rule.ValidateEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AddWeekDayCommand {

    @NotEmpty
    @UpperCaseValidator
    @ValidateEnum(enumClass = WeekDayEnum.class)
    @Size.List({
            @Size(
                    min = FieldConstraints.ForWeekDay.MIN_WEEKDAY_NAME_LENGTH,
                    message = "Weekday Name must have at least {min} characters"),
            @Size(
                    max = FieldConstraints.ForWeekDay.MAX_WEEKDAY_NAME_LENGTH,
                    message = "Weekday Name can have at most {max} characters")
    })
    @ApiModelProperty(
            notes =
                    "Weekday Name length should be between ["
                            + FieldConstraints.ForWeekDay.MIN_WEEKDAY_NAME_LENGTH
                            + ","
                            + FieldConstraints.ForWeekDay.MAX_WEEKDAY_NAME_LENGTH
                            + "]",
            required = true)
    private String weekDayName;
}
