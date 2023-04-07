package ru.timofeev.translator.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.timofeev.translator.dto.error.BadRequestErrorDTO;
import ru.timofeev.translator.exception.InvalidRequestTextException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BadRequestErrorDTO> catchInputTextIsEmpty(InvalidRequestTextException e) {
        return new ResponseEntity<>
                (new BadRequestErrorDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
