package com.project.book.ticket.ticketbookingapi.controller;

import com.project.book.ticket.ticketbookingapi.exception.TicketNotFoundException;
import com.project.book.ticket.ticketbookingapi.model.TicketDetails;
import com.project.book.ticket.ticketbookingapi.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.project.book.ticket.ticketbookingapi.constants.TicketBookingConstants.*;

import java.util.Optional;

@RestController
public class HelloWorldController {

    @Autowired
    private  TicketBookingService ticketBookingService;

    @PostMapping("/reservation")
    public void ticketReservation(@RequestBody TicketDetails details){
        ticketBookingService.bookTicket(details);
    }

    @GetMapping("/pnr/{no}")
    public ResponseEntity<TicketDetails> getTicketDetails(@PathVariable("no") String pnrNo){
        return  new ResponseEntity<TicketDetails>(ticketBookingService.getTicketDetails(pnrNo).orElseThrow(()->new TicketNotFoundException(TICKET_NOT_FOUND_MESSAGE+pnrNo)), HttpStatus.OK);
  }
}
