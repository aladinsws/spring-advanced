package dev.hotel.controller;

import dev.hotel.exception.ClientNotFoundException;
import dev.hotel.exception.ReservationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ErrorsHandler extends ResponseEntityExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(ErrorsHandler.class);

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> onClientNotFoundException(ClientNotFoundException ex) {
        LOGGER.error("Not Found", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<?> gererResaExcept(ReservationException ex) {

        /*
        {
            "messages" : ["message 1", "message 2"]
        }
         */
        Map<String, List<String>> body = new HashMap<>();
        body.put("messages", ex.getErreurs());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> onDataAccessException(DataAccessException ex) {
        LOGGER.error("Erreur base de données", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Une erreur inattendue s'est produite, veuillez contacter le support");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("erreurs de data");
    }
}
