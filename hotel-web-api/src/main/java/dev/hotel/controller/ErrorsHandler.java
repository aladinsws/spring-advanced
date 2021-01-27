package dev.hotel.controller;

import dev.hotel.exception.ClientNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorsHandler extends ResponseEntityExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(ErrorsHandler.class);

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> onClientNotFoundException(ClientNotFoundException ex) {
        LOGGER.error("Not Found", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("erreurs de data");
    }
    

}
