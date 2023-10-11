package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class TestLoginController {

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody Map<String, Object> requestData) {
        // For demo purposes, let's create a hardcoded user with user_id as "testuser" and password as "password"
        String user_id = requestData.get("user_id").toString();
        String password = requestData.get("password").toString();
        if ("testuser".equals(user_id) && "password".equals(password)) {
            return ResponseEntity.ok().body(Map.of("status", "success"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("status", "failed", "message", "Invalid user_id or password"));
        }
    }
}