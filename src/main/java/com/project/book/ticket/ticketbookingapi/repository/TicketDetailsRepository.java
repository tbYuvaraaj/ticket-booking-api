package com.project.book.ticket.ticketbookingapi.repository;

import com.project.book.ticket.ticketbookingapi.model.TicketDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDetailsRepository extends MongoRepository<TicketDetails,String> {
}
