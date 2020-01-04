package com.devtypes.retrospec.common.exception;

import com.devtypes.retrospec.common.rest.Envelope;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RetrospecBusinessException.class)
    protected ResponseEntity<Envelope> handleXvelaBusinessException(RetrospecBusinessException exception) {
        log.error("Business error: " + exception.getMessage());
        return buildErrorResponse(exception, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(RetrospecNotFoundException.class)
    protected ResponseEntity<Envelope> handleXvelaNotFoundException(RetrospecNotFoundException exception) {
        log.error("Not found error: " + exception.getMessage());
        return buildErrorResponse(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Envelope> handleValidationException(MethodArgumentNotValidException exception) {
        List<RetrospecError> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new RetrospecError(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        log.error("Validation error: {}", errors);
        return buildValidationErrorResponse(errors);
    }

    // TODO: Implement again when using Spring Boot Security
//    @ExceptionHandler(AccessDeniedException.class)
//    protected ResponseEntity<Envelope> handleAccessDeniedException(AccessDeniedException exception) {
//        return buildErrorResponse(exception, HttpStatus.FORBIDDEN);
//    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Envelope> handleGenericException(Exception exception) {
        log.error("Runtime exception: ", exception);
        return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Envelope> buildErrorResponse(Exception exception, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .body(Envelope.error(exception.getMessage()));
    }

    private ResponseEntity<Envelope> buildValidationErrorResponse(List<RetrospecError> errors) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Envelope.error(errors));
    }

}
