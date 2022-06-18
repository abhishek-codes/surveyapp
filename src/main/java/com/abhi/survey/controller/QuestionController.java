package com.abhi.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.survey.model.Questions;
import com.abhi.survey.service.QuestionService;
import com.abhi.survey.service.SurveyService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;

    @GetMapping("/{surveyId}")
    public List<Questions> getQuestionsBySurvey(@PathVariable Integer surveyId){
        return questionService.getAllQuestionBySurvey(surveyId);
    }

}
