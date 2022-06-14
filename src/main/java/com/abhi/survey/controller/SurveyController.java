package com.abhi.survey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SurveyController {

    @GetMapping
    public String homePage(){
        return "Welcome";
    }

    @GetMapping("/abhi")
    public String getAbhi(){
        return "Abhi";
    }
}
