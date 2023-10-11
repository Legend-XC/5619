package com.example.demo.Entity;

import java.time.LocalDate;

public class Bill {
    private int bill_id;
    private int user_id;
    private double bill_amount;
    private LocalDate bill_start_time;
    private LocalDate bill_due_time;
    private boolean bill_is_paid = false;
    private String bill_address;
    private String bill_name;

    public Bill(){}

    public int getUser_id() {
        return user_id;
    }

    public double getBill_amount() {
        return bill_amount;
    }

    public int getBill_id() {
        return bill_id;
    }

    public LocalDate getBill_start_time() {
        return bill_start_time;
    }

    public LocalDate getBill_due_time() {
        return bill_due_time;
    }

    public String getBill_address() {
        return bill_address;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setBill_amount(double bill_amount) {
        this.bill_amount = bill_amount;
    }

    public void setBill_address(String bill_address) {
        this.bill_address = bill_address;
    }

    public void setBill_due_time(LocalDate bill_due_time) {
        this.bill_due_time = bill_due_time;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public void setBill_is_paid(boolean bill_is_paid) {
        this.bill_is_paid = bill_is_paid;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public void setBill_start_time(LocalDate bill_start_time) {
        this.bill_start_time = bill_start_time;
    }
}
