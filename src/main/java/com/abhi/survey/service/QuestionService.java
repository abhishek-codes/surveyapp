package com.abhi.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.survey.model.Questions;
import com.abhi.survey.model.Survey;
import com.abhi.survey.repos.QuestionRepository;
import com.abhi.survey.repos.SurveyRepository;

@Service
public class QuestionService {
    
    @Autowired
    private QuestionRepository questionRepository;

    private SurveyRepository surveyRepository;

    public List<Questions> getAllQuestionBySurvey(Integer surveyId){
        Survey survey = surveyRepository.findBySurveyId(surveyId);
        List<Questions> questions = questionRepository.findBySurvey(survey);
        return questions;
    }

    public Questions addQuestions(Questions questions){
        questions.setQuestionId(null);
        Questions questions2 = questionRepository.save(questions);
        return questions2;
    }
}
