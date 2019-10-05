package com.rokib.springBootApiValidation.web;

import com.rokib.springBootApiValidation.dto.account.request.SignUpCommand;
import com.rokib.springBootApiValidation.dto.weekDay.request.AddWeekDayCommand;
import com.rokib.springBootApiValidation.service.contract.WeekDayService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rest/week-day", produces = {"application/json"}, consumes = {"application/json"})
public class WeekDayController {

    private final WeekDayService weekDayService;

    public WeekDayController(WeekDayService weekDayService) {
        this.weekDayService = weekDayService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Weekday Successfully saved"),
            @ApiResponse(code = 400, message = "Bad Request or Validation Failed"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED) // ==> This is define to turn off default response messages
    @PostMapping(path = "/add")
    public ResponseEntity add(@Valid @RequestBody AddWeekDayCommand addWeekDayCommand) {
        weekDayService.add(addWeekDayCommand.getWeekDayName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
