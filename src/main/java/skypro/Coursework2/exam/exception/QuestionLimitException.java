package skypro.Coursework2.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionLimitException extends RuntimeException {
    public QuestionLimitException(String message) {
        super(message);
    }
}
