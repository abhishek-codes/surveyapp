package com.abhi.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhi.survey.model.Survey;
import com.abhi.survey.model.User;
import com.abhi.survey.repos.SurveyRepository;
import com.abhi.survey.repos.UserRespository;

import net.bytebuddy.implementation.bytecode.Throw;

public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRespository userRespository;

    public List<Survey> getAllSurvey(){
        return this.surveyRepository.findAll();
    }

    public Survey addSurvey(Survey survey){
        survey.setSurveyId(null);
        Survey survey2 = surveyRepository.save(survey);
        return survey2;
    }

    public List<Survey> getSurveyByUser(User user){
        return surveyRepository.findByUser(user);
    }

}
