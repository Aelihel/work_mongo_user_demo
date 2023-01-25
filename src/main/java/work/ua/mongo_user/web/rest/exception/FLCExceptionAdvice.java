package work.ua.mongo_user.web.rest.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FLCExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> flcException(FLCException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(problem, ex.getStatus());
    }
}