package com.abhi.survey.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.survey.model.User;

public interface UserRespository extends JpaRepository<User,Integer>{
    User findByUserEmail(String userEmail);
}
