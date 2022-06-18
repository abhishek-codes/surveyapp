package com.abhi.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.survey.repos.AnswerRepository;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    
    @Autowired
    private AnswerRepository answerRepository;

}
