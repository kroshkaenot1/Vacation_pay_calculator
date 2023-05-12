package com.neoflex.Vacation_pay_calculator.util;

import java.time.LocalDate;

public class VacationPay {
    private double salary;
    private int days;
    private LocalDate startVacationDate;
    private double amountOfVacationPay;


    public VacationPay() {
    }

    public VacationPay(double salary, int days, LocalDate startVacationDate, double amountOfVacationPay) {
        this.salary = salary;
        this.days = days;
        this.startVacationDate = startVacationDate;
        this.amountOfVacationPay = amountOfVacationPay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LocalDate getStartVacationDate() {
        return startVacationDate;
    }

    public void setStartVacationDate(LocalDate startVacationDate) {
        this.startVacationDate = startVacationDate;
    }

    public VacationPay(double amountOfVacationPay) {
        this.amountOfVacationPay = amountOfVacationPay;
    }

    public double getAmountOfVacationPay() {
        return amountOfVacationPay;
    }

    public void setAmountOfVacationPay(double amountOfVacationPay) {
        this.amountOfVacationPay = amountOfVacationPay;
    }
}
