package br.com.spring.jpa.exception;

import br.com.spring.jpa.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(exception= NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage());
        return ResponseEntity.badRequest().body(errorDTO);
    }
}
