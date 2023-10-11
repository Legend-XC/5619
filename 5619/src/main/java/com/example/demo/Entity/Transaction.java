package com.example.demo.Entity;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Transaction {
    private int tra_id;
    private int user_id;
    private double tra_amount;
    private String tra_way;
    private LocalDate tra_time;
    private String tra_type;
    private String tra_currency;

    public Transaction(){}

    public int getUser_id() {
        return user_id;
    }

    public double getTra_amount() {
        return tra_amount;
    }

    public int getTra_id() {
        return tra_id;
    }

    public LocalDate getTra_time() {
        return tra_time;
    }

    public String getTra_currency() {
        return tra_currency;
    }

    public String getTra_type() {
        return tra_type;
    }

    public String getTra_way() {
        return tra_way;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTra_amount(double tra_amount) {
        this.tra_amount = tra_amount;
    }

    public void setTra_currency(String tra_currency) {
        this.tra_currency = tra_currency;
    }

    public void setTra_id(int tra_id) {
        this.tra_id = tra_id;
    }

    public void setTra_time(LocalDate tra_time) {
        this.tra_time = tra_time;
    }

    public void setTra_type(String tra_type) {
        this.tra_type = tra_type;
    }

    public void setTra_way(String tra_way) {
        this.tra_way = tra_way;
    }
}
