package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private int user_id;
    @Column(name = "user_name", nullable = false)
    private String user_name;
    @Column(name = "user_password", nullable = false)
    private String user_password;
    @Column(name = "month_limit_currency")
    private double month_limit_currency;
    @Column(name = "month_limit_type")
    private String month_limit_type;
    @Column(name = "user_email", nullable = false)
    private String user_email;
    public User(){}

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public double getMonth_limit_currency() {
        return month_limit_currency;
    }
    public String getUser_email() {
        return user_email;
    }

    public String getMonth_limit_type() {
        return month_limit_type;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setMonth_limit_currency(double month_limit_currency) {
        this.month_limit_currency = month_limit_currency;
    }

    public void setMonth_limit_type(String month_limit_type) {
        this.month_limit_type = month_limit_type;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
