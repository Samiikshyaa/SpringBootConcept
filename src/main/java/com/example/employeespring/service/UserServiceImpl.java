package com.example.employeespring.service;

import com.example.employeespring.repository.UserRepository;
import com.example.employeespring.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public void signup(User u) {
        userRepository.save(u);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }


}
