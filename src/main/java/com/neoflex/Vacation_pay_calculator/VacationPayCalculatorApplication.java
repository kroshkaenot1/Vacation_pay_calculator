package com.neoflex.Vacation_pay_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.neoflex.Vacation_pay_calculator.api")
public class VacationPayCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacationPayCalculatorApplication.class, args);
	}

}
