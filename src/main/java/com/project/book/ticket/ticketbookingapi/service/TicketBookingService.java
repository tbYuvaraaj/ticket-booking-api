package com.project.book.ticket.ticketbookingapi.service;

import com.project.book.ticket.ticketbookingapi.exception.InvalidInputException;
import com.project.book.ticket.ticketbookingapi.model.TicketDetails;
import com.project.book.ticket.ticketbookingapi.repository.TicketDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class TicketBookingService {

    @Autowired
    TicketDetailsRepository ticketDetailsRepository;

    public void bookTicket(TicketDetails ticketDetails){
        ticketDetails.setPnrNumber(generatePnrNumber());

        if(ticketDetails.getAge() < 0){
            throw new InvalidInputException("Provided age is not valid.");
        }
        ticketDetailsRepository.save(ticketDetails);
    }

    public Optional<TicketDetails> getTicketDetails(String pnrNo){
        return ticketDetailsRepository.findById(pnrNo);
    }

    public static String  generatePnrNumber(){
        StringBuilder strb = new StringBuilder();
        String str ="1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Supplier<Character> randomChar = () -> str.charAt((int)(Math.random()*62));

        for(int i=1;i<=8;i++){
            strb.append(randomChar.get());
        }
        return strb.toString();
    }
}
