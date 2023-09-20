package com.example.demo.Mapping;

import com.example.demo.Entity.User;
import java.util.List;

public interface UserMapper {
    List<User> findAll();
    User findById(int user_id);
    void insert(User user);
    void update(User user);
    void delete(int user_id);
}
