package com.rokib.springBootApiValidation.persistence.entity;

import com.rokib.springBootApiValidation.constants.FieldConstraints;
import com.rokib.springBootApiValidation.constants.WeekDayEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WeekDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = FieldConstraints.ForWeekDay.MAX_WEEKDAY_NAME_LENGTH)
    @Enumerated(EnumType.STRING)
    private WeekDayEnum weekDayName;

}
