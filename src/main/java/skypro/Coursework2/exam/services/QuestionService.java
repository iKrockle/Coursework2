package skypro.Coursework2.exam.services;

import skypro.Coursework2.exam.entity.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();
    int size();
}
