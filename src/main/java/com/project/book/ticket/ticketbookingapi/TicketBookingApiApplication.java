package com.project.book.ticket.ticketbookingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class TicketBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApiApplication.class, args);
	}

}
