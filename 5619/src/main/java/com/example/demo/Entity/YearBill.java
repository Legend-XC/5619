package com.example.demo.Entity;

import java.time.Year;

public class YearBill {
    private int year_bill_id;
    private int user_id;
    private String year;
    private double year_bill_amount;
    private String year_bill_currency;
    public YearBill(){}

    public int getUser_id() {
        return user_id;
    }

    public String getYear() {
        return year;
    }

    public double getYear_bill_amount() {
        return year_bill_amount;
    }

    public int getYear_bill_id() {
        return year_bill_id;
    }

    public String getYear_bill_currency() {
        return year_bill_currency;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setYear_bill_amount(double year_bill_amount) {
        this.year_bill_amount = year_bill_amount;
    }

    public void setYear_bill_currency(String year_bill_currency) {
        this.year_bill_currency = year_bill_currency;
    }

    public void setYear_bill_id(int year_bill_id) {
        this.year_bill_id = year_bill_id;
    }
}
