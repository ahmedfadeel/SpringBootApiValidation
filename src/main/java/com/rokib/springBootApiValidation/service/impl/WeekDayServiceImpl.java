package com.rokib.springBootApiValidation.service.impl;

import com.rokib.springBootApiValidation.constants.WeekDayEnum;
import com.rokib.springBootApiValidation.persistence.entity.WeekDay;
import com.rokib.springBootApiValidation.persistence.repository.WeekDayRepository;
import com.rokib.springBootApiValidation.service.contract.WeekDayService;
import org.springframework.stereotype.Service;

@Service
public class WeekDayServiceImpl implements WeekDayService {

    private final WeekDayRepository weekDayRepository;

    public WeekDayServiceImpl(WeekDayRepository weekDayRepository) {
        this.weekDayRepository = weekDayRepository;
    }

    @Override
    public void add(String weekDayName) {
        WeekDay weekDay = new WeekDay();
        weekDay.setWeekDayName(WeekDayEnum.valueOf(weekDayName));
        weekDayRepository.save(weekDay);
    }
}
