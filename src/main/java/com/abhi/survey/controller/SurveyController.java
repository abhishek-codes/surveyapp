package com.abhi.survey.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.survey.model.Questions;
import com.abhi.survey.model.Survey;
import com.abhi.survey.service.SurveyService;


@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurvey(){
        return new ResponseEntity<List<Survey>>(surveyService.getAllSurvey(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Survey> addSurvey(@Valid @RequestBody Survey survey){
        return new ResponseEntity<>(surveyService.addSurvey(survey), HttpStatus.OK);
    }

}
