package com.rokib.springBootApiValidation.persistence.repository;


import com.rokib.springBootApiValidation.persistence.entity.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekDayRepository extends JpaRepository<WeekDay, Integer> {

}
