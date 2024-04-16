package skypro.Coursework2.exam.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import skypro.Coursework2.exam.entity.Question;
import skypro.Coursework2.exam.repository.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final QuestionRepository questionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionForDelete = new Question(question, answer);
        questionRepository.remove(questionForDelete);
        return questionForDelete;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    public int size() {
        Collection<Question> questions = questionRepository.getAll();
        return questions.size();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        Collection<Question> questions = questionRepository.getAll();
        int randomInt = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomInt);
    }
}
