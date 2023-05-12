package com.neoflex.Vacation_pay_calculator.services;

import com.neoflex.Vacation_pay_calculator.util.VacationPay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VacationPayServiceTest {
    private static final double DELTA = 0.1;
    @InjectMocks
    private VacationPayService vacationPayService;

    @Test
    void calculateVacationPay() {
        double salary = 40000;
        int days = 20;
        double expected = 27303.7542;
        VacationPay vacationPay = vacationPayService.calculateVacationPay(salary,days,null);
        Assertions.assertEquals(expected,vacationPay.getAmountOfVacationPay(),DELTA);


        salary = 25000;
        days = 14;
        expected = 11945.3925;
        vacationPay = vacationPayService.calculateVacationPay(salary,days,null);
        Assertions.assertEquals(expected,vacationPay.getAmountOfVacationPay(),DELTA);
    }
}