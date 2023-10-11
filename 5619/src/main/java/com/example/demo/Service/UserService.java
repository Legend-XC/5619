package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User authenticate(int user_id, String password){
        User user = userMapper.findById(user_id);
        if(user != null && (user.getUser_id() == user_id) && (user.getUser_password().equals(password))){
            return user;
        }
        return null;
    }

    public User registerUser(int user_id, String password){
        User newUser = new User();
        newUser.setUser_id(user_id);
        newUser.setUser_password(password);
        userMapper.insert(newUser);
        return newUser;
    }
}
