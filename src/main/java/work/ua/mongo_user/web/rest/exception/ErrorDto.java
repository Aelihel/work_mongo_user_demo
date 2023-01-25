package work.ua.mongo_user.web.rest.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

public class ErrorDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String message;
    public HttpStatus status;
    public String path;
}
