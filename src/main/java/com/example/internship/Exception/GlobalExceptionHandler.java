package com.example.internship.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleNotFoundException(IllegalArgumentException ex) {
        // Создаем тело ответа с сообщением об ошибке
        ErrorDetails errorDetails = new ErrorDetails("NOT_FOUND", ex.getMessage());

        // Возвращаем ошибку с кодом 404 (NOT FOUND)
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Можно добавить обработку других исключений
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        // Общая ошибка
        ErrorDetails errorDetails = new ErrorDetails("INTERNAL_SERVER_ERROR", "An unexpected error occurred");

        // Возвращаем ошибку с кодом 500 (INTERNAL SERVER ERROR)
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
