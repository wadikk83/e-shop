package by.nekhviadovich.store.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityException.class)
    public ResponseEntity<Object> handleEntityException(HttpServletRequest request, EntityException ex) {
        ApiError apiError = new ApiError("EntityException " + request.getRequestURI(), ex.getMessage());
        logger.error("EntityException " + request.getRequestURI() + ex.getMessage());
        return ResponseEntity.status(NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(HttpServletRequest request, ValidationException ex) {
        ApiError apiError = new ApiError("ValidationException " + request.getRequestURI(), ex.getMessage());
        logger.error("ValidationException " + request.getRequestURI() + ex.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthorizationException(HttpServletRequest request, AuthenticationException ex) {
        ApiError apiError = new ApiError("AuthorizationException " + request.getRequestURI(), ex.getMessage());
        logger.error("AuthorizationException " + request.getRequestURI() + ex.getMessage());
        return ResponseEntity.status(UNAUTHORIZED).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerError(HttpServletRequest request, Exception ex) {
        ApiError apiError = new ApiError("InternalException " + request.getRequestURI(), ex.getMessage());
        logger.error("InternalException " + request.getRequestURI() + ex.getMessage());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(apiError);
    }
}
