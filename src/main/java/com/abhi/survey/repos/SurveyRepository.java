package com.abhi.survey.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.survey.model.Survey;
import com.abhi.survey.model.User;

public interface SurveyRepository extends JpaRepository<Survey,Integer> {
    List<Survey> findByUser(User user);
    Survey findBySurveyId(Integer surveyId);
}
