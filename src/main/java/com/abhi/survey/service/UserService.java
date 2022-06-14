package com.abhi.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abhi.survey.model.User;
import com.abhi.survey.repos.UserRespository;

@Service
public class UserService {
    
    @Autowired
    private UserRespository userRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUser(){
        return userRepos.findAll();
    }

    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserId(null);
        User createdUser = userRepos.save(user);
        return createdUser;
    }

    public User getByEmail(String email){
        return userRepos.findByUserEmail(email);
    }

}
