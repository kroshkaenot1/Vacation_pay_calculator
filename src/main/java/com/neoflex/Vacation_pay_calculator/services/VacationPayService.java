package com.neoflex.Vacation_pay_calculator.services;

import com.neoflex.Vacation_pay_calculator.api.DayOffFeignClient;
import com.neoflex.Vacation_pay_calculator.util.VacationPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class VacationPayService {
    private static final double AVERAGE_DAY_IN_MONTH = 29.3;

    private final DayOffFeignClient dayOffFeignClient;
    @Autowired
    public VacationPayService(DayOffFeignClient dayOffFeignClient) {
        this.dayOffFeignClient = dayOffFeignClient;
    }

    public VacationPay calculateVacationPay(double salary, int days, LocalDate startVacationDate){

        if (salary < 0 || days < 0){
            return new VacationPay();
        }
        double amountOfVacationPay;
        if (startVacationDate == null){
            amountOfVacationPay = (salary/AVERAGE_DAY_IN_MONTH)*days;
        }
        else {
            int count = 0;
            LocalDate currentDate = startVacationDate;
            for(int i = 0; i < days; i++){
                // если в результате запроса к API вернется 1 - то день считается выходным/праздничным
                if(dayOffFeignClient.getDayOff(currentDate).equals("1")
                        &&!currentDate.getDayOfWeek().toString().equals("SATURDAY")
                        &&!currentDate.getDayOfWeek().toString().equals("SUNDAY")){
                    count++;
                }
                currentDate = currentDate.plusDays(1);
            }
            amountOfVacationPay = (salary/AVERAGE_DAY_IN_MONTH)*(days-count);
        }
        return new VacationPay(salary,days,startVacationDate,amountOfVacationPay);
    }
}
