package guru.springframework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Project implementation for the Not found exception.
 * @author andres
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    /**
     * Instantiates a new Not found exception.
     */
    public NotFoundException() {
    }

    /**
     * Instantiates a new Not found exception.
     *
     * @param message
     *         the message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Not found exception.
     *
     * @param message
     *         the message
     * @param cause
     *         the cause
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
