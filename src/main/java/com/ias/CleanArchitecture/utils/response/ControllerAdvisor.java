package com.ias.CleanArchitecture.utils.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<Response> handleException(NoSuchElementException ex){
        return buildResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    private ResponseEntity<Response> handleException(StudentListEmptyException ex){
        return buildResponse(ex, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler
    private ResponseEntity<ResponseError> handleException(InvalidDataException e){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errors = e.getResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return buildResponse(new Exception("La data enviada no es valida."),httpStatus, errors);
    }

    @ExceptionHandler
    private ResponseEntity<Response> handleException(IllegalArgumentException e){

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        return buildResponse(e,httpStatus);
    }

    private ResponseEntity<Response> buildResponse(Exception e, HttpStatus status){
        Response response = new Response(e.getMessage(), status.value());
        return new ResponseEntity<>(response, status);
    }

    private ResponseEntity<ResponseError> buildResponse(Exception e, HttpStatus status, List<String> errors){
        ResponseError response = new ResponseError(e.getMessage(), status.value(), errors);
        return new ResponseEntity<>(response, status);
    }
}
