package skypro.Coursework2.exam.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.Coursework2.exam.entity.Question;
import skypro.Coursework2.exam.exception.QuestionLimitException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions_withException() {
        int amount = 5;

        String q1 = "q1?";
        String a1 = "a1";
        String q2 = "q2";
        String a2 = "a2";

        Set<Question> allQuestions = new HashSet<>();
        allQuestions.add(new Question(q1, a1));
        allQuestions.add(new Question(q2, a2));

        when(questionService.getAll()).thenReturn(allQuestions);
        String expectedMessage = String.format("Запрошенно %s вопросов, в базе %s вопросов", amount, allQuestions.size());

        Exception exception = assertThrows(QuestionLimitException.class,
                () -> examinerService.getQuestions(amount));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getQuestions_success() {
        int amount = 1;

        String q1 = "q1?";
        String a1 = "a1";
        String q2 = "q2";
        String a2 = "a2";

        Question question1 = new Question(q1, a1);
        Question question2 = new Question(q2, a2);

        Set<Question> allQuestions = new HashSet<>();
        allQuestions.add(question1);
        allQuestions.add(question2);

        when(questionService.getAll()).thenReturn(allQuestions);
        when(questionService.getAll()).thenReturn(allQuestions);
        when(questionService.getRandomQuestion()).thenReturn(question1);
        when(questionService.getRandomQuestion()).thenReturn(question2);

        Collection<Question> questions = examinerService.getQuestions(amount);
        verify(questionService, times(2)).getAll();
        verify(questionService).getRandomQuestion();
    }
}