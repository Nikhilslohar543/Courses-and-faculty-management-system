package com.springboot.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Data
@AllArgsConstructor
public class ErrorResponse<T> {

    @ExceptionHandler(CFMSException.class)
    public ResponseEntity<APIResponse<?>> handleResourceNotFound(CFMSException ex) {

        APIResponse<?> response = new APIResponse<>(
                false,
                ex.getMessage(),
                null
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<?>> handleGenericException(Exception ex) {

        APIResponse<?> response = new APIResponse<>(
                false,
                "Something went wrong",
                null);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
