package skypro.Coursework2.exam.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.Coursework2.exam.entity.Question;
import skypro.Coursework2.exam.repository.QuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private MathQuestionService mathQuestionService;

    @Test
    void add() {

        String question = "Сколько методов у класса Object?";
        String answer = "8";


        Question expectedQuestion = new Question(question, answer);
        when(questionRepository.add(expectedQuestion)).thenReturn(expectedQuestion);


        Question actualQuestion = mathQuestionService.add(question, answer);
        assertEquals(expectedQuestion, actualQuestion);
        verify(questionRepository).add(expectedQuestion);
        verifyNoMoreInteractions(questionRepository);
    }

    @Test
    void getAll() {

        String q1 = "q1?";
        String a1 = "a1";
        String q2 = "q2";
        String a2 = "a2";

        Set<Question> allQuestions = new HashSet<>();
        allQuestions.add(new Question(q1, a1));
        allQuestions.add(new Question(q2, a2));

        when(questionRepository.getAll()).thenReturn(allQuestions);


        Collection<Question> actualResult = mathQuestionService.getAll();
        assertEquals(allQuestions, actualResult);
        verify(questionRepository).getAll();
        verifyNoMoreInteractions(questionRepository);
    }

    @Test
    void getRandomQuestion() {

        String q1 = "q1?";
        String a1 = "a1";
        String q2 = "q2";
        String a2 = "a2";

        Set<Question> allQuestions = new HashSet<>();
        allQuestions.add(new Question(q1, a1));
        allQuestions.add(new Question(q2, a2));
        when(questionRepository.getAll()).thenReturn(allQuestions);


        Question question = mathQuestionService.getRandomQuestion();

        assertTrue(allQuestions.contains(question));
        verify(questionRepository).getAll();
        verifyNoMoreInteractions(questionRepository);
    }
}