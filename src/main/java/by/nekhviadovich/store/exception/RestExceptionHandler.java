package by.nekhviadovich.store.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /*@ExceptionHandler({ UserNotFoundException.class })
    public ResponseEntity<Object> handleUserNotFound(RuntimeException ex, WebRequest request) {
        logger.error("404 Status Code", ex);
        GenericResponse bodyOfResponse = new GenericResponse(
                messages.getMessage("message.userNotFound", null, request.getLocale()), "UserNotFound");

        return handleExceptionInternal(
                ex, bodyOf*/
}
