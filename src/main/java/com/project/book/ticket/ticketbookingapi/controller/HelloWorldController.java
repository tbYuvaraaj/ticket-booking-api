package com.project.book.ticket.ticketbookingapi.controller;

import com.project.book.ticket.ticketbookingapi.exception.TicketNotFoundException;
import com.project.book.ticket.ticketbookingapi.model.TicketDetails;
import com.project.book.ticket.ticketbookingapi.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HelloWorldController {

    @Autowired
    private  TicketBookingService ticketBookingService;

    @RequestMapping("/test")
    public String sample(){
        return "Good Morning..";
    }

    @PostMapping("/reservation")
    public void ticketReservation(@RequestBody TicketDetails details){
        ticketBookingService.bookTicket(details);
        System.out.println("Ticket has been booked!");
    }

    @GetMapping("/pnr/{no}")
    public ResponseEntity<TicketDetails> getTicketDetails(@PathVariable("no") String pnrNo){
        return  new ResponseEntity<TicketDetails>(ticketBookingService.getTicketDetails(pnrNo).orElseThrow(()->new TicketNotFoundException("pnrNo")), HttpStatus.OK);
  }
}
