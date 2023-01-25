package work.ua.mongo_user.web.rest.exception;

import org.springframework.http.HttpStatus;

public class FLCException extends RuntimeException {
    private HttpStatus status;

    public FLCException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public FLCException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
