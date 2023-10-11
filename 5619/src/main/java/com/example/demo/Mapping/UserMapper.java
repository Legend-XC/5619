package com.example.demo.Mapping;

import com.example.demo.Entity.User;
import java.util.List;

public interface UserMapper {
    List<User> findAll();
    User findById(int user_id);
    void insert(User user);
    void update(User user);
    void delete(int user_id);

    void updatePassword(User user, String password);
    void updateName(User user, String user_name);
    void updateCurrency(User user, double month_limit_currency);
    void updateType(User user, String month_limit_type);
}
