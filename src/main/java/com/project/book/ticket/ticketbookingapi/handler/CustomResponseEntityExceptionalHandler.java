package com.project.book.ticket.ticketbookingapi.handler;

import com.project.book.ticket.ticketbookingapi.exception.CustomExceptionResponse;
import com.project.book.ticket.ticketbookingapi.exception.InvalidInputException;
import com.project.book.ticket.ticketbookingapi.exception.TicketNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionalHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<Object> handleTicketNotFoundException(Exception ex, WebRequest request){
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false)
        );

        return new ResponseEntity<Object>(customExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Object> handleInvalidInputException(Exception ex, WebRequest request){
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false)
        );
        return new ResponseEntity<Object>(customExceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
