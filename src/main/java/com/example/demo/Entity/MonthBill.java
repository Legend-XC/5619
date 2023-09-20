package com.example.demo.Entity;

public class MonthBill {
    private int month_bill_id;
    private int user_id;
    private String year;
    private String month;
    private double month_bill_amount;
    private String month_bill_currency;

    public MonthBill(){}

    public int getMonth_bill_id() {
        return month_bill_id;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public int getUser_id() {
        return user_id;
    }

    public double getMonth_bill_amount() {
        return month_bill_amount;
    }

    public String getMonth_bill_currency() {
        return month_bill_currency;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setMonth_bill_amount(double month_bill_amount) {
        this.month_bill_amount = month_bill_amount;
    }

    public void setMonth_bill_currency(String month_bill_currency) {
        this.month_bill_currency = month_bill_currency;
    }

    public void setMonth_bill_id(int month_bill_id) {
        this.month_bill_id = month_bill_id;
    }
}