package com.project.book.ticket.ticketbookingapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException {

    private String message;
    public TicketNotFoundException(String message) {
        super(message);
    }
}
