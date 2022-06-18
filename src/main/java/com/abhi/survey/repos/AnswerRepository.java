package com.abhi.survey.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.survey.model.Answer;
import com.abhi.survey.model.Questions;
import com.abhi.survey.model.User;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    Answer findByQuestions(Questions questions);
    List<Answer> findByUser(User user);
}
