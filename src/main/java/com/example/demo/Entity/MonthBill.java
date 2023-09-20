package com.example.demo.Entity;

public class MonthBill {
    private int month_tran_id;
    private int user_id;
    private String year;
    private String month;
    private double month_tran_income;
    private double month_tran_spending;
    private double month_tran_invest;
    private double month_tran_currency;

    public MonthBill(){}

    public int getUser_id() {
        return user_id;
    }

    public double getMonth_tran_currency() {
        return month_tran_currency;
    }

    public double getMonth_tran_income() {
        return month_tran_income;
    }

    public double getMonth_tran_invest() {
        return month_tran_invest;
    }

    public double getMonth_tran_spending() {
        return month_tran_spending;
    }

    public int getMonth_tran_id() {
        return month_tran_id;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setMonth_tran_currency(double month_tran_currency) {
        this.month_tran_currency = month_tran_currency;
    }

    public void setMonth_tran_id(int month_tran_id) {
        this.month_tran_id = month_tran_id;
    }

    public void setMonth_tran_income(double month_tran_income) {
        this.month_tran_income = month_tran_income;
    }

    public void setMonth_tran_invest(double month_tran_invest) {
        this.month_tran_invest = month_tran_invest;
    }

    public void setMonth_tran_spending(double month_tran_spending) {
        this.month_tran_spending = month_tran_spending;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
