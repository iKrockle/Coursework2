package skypro.Coursework2.exam.repository;

import skypro.Coursework2.exam.entity.Question;

import java.util.Collection;

public interface  QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
