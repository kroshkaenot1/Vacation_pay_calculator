package com.neoflex.Vacation_pay_calculator.controllers;

import com.neoflex.Vacation_pay_calculator.services.VacationPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VacationPayController {
    @Autowired
    private VacationPayService vacationService;
    @GetMapping(path = "/calculacte",produces = "application/json")
    public ResponseEntity<?> calculate(@RequestParam("salary") double salary,
                                       @RequestParam("days") int days,
                                       @RequestParam(value = "date",required = false)
                                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startVacationDate){

        return new ResponseEntity<>(vacationService.calculateVacationPay(salary,days,startVacationDate), HttpStatus.OK);
    }
}
