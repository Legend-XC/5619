package com.example.demo.Entity;

public class YearTransaction {
    private int year_tra_id;
    private int user_id;
    private String year;
    private double year_tra_spending;
    private double year_tra_income;
    private double year_tra_invest;
    private String year_tra_currency;

    public YearTransaction(){}

    public int getUser_id() {
        return user_id;
    }

    public String getYear() {
        return year;
    }

    public double getYear_tra_income() {
        return year_tra_income;
    }

    public double getYear_tra_invest() {
        return year_tra_invest;
    }

    public double getYear_tra_spending() {
        return year_tra_spending;
    }

    public int getYear_tra_id() {
        return year_tra_id;
    }

    public String getYear_tra_currency() {
        return year_tra_currency;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setYear_tra_currency(String year_tra_currency) {
        this.year_tra_currency = year_tra_currency;
    }

    public void setYear_tra_id(int year_tra_id) {
        this.year_tra_id = year_tra_id;
    }

    public void setYear_tra_income(double year_tra_income) {
        this.year_tra_income = year_tra_income;
    }

    public void setYear_tra_invest(double year_tra_invest) {
        this.year_tra_invest = year_tra_invest;
    }

    public void setYear_tra_spending(double year_tra_spending) {
        this.year_tra_spending = year_tra_spending;
    }
}
