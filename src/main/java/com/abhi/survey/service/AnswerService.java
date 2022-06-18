package com.abhi.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.survey.model.Answer;
import com.abhi.survey.model.Questions;
import com.abhi.survey.repos.AnswerRepository;

@Service
public class AnswerService {
    
    @Autowired
    private AnswerRepository answerRepository;

    public Answer getAnswerByQuestion(Questions questions){
        return answerRepository.findByQuestions(questions);
    }

    public Answer addAnswer(Answer answer){
        answer.setAnswerId(null);
        return answerRepository.save(answer);
    }
}
