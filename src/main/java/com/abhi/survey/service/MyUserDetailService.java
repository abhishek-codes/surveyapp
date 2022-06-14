package com.abhi.survey.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhi.survey.model.User;
import com.abhi.survey.repos.UserRespository;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRespository.findByUserEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid Id");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getPassword(), new ArrayList<>());
    }
    
}
