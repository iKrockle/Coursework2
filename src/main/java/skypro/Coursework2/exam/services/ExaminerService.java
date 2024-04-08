package skypro.Coursework2.exam.services;

import skypro.Coursework2.exam.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
