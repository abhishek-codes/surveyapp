package com.abhi.survey.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.survey.model.Questions;
import com.abhi.survey.model.Survey;

public interface QuestionRepository extends JpaRepository<Questions,Integer>{
    List<Questions> findBySurvey(Survey survey);
    Questions findByQuestionId(Integer questionId);
}
