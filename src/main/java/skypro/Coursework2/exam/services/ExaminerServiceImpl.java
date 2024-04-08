package skypro.Coursework2.exam.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import skypro.Coursework2.exam.entity.Question;
import skypro.Coursework2.exam.exception.QuestionLimitException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> javaQuestions = javaQuestionService.getAll();
        Collection<Question> mathQuestions = mathQuestionService.getAll();
        Set<Question> allQuestions = new HashSet<>();
        allQuestions.addAll(javaQuestions);
        allQuestions.addAll(mathQuestions);
        int allQuestionsSize = allQuestions.size();

        if (allQuestionsSize < amount) {
            throw new QuestionLimitException(String.format("Запрошенно %s вопросов, в базе %s вопросов", amount, allQuestionsSize));
        }

        Random random = new Random();

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            if (random.nextBoolean()&&javaQuestionService.size()>0) {
                result.add(javaQuestionService.getRandomQuestion());
            }
            else if (mathQuestionService.size()>0) {
                result.add(mathQuestionService.getRandomQuestion());
            }
            else {
                result.add(javaQuestionService.getRandomQuestion());
            }
        }

        return result;
    }
}
