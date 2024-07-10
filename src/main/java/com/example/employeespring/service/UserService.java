package com.example.employeespring.service;

import com.example.employeespring.view.User;

public interface UserService {
    void signup(User u);
    User login(String email, String password);
}
