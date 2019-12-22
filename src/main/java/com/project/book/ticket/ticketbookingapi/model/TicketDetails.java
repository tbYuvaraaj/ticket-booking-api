package com.project.book.ticket.ticketbookingapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Date;

@Document
public class TicketDetails {

    @Id
    private String pnrNumber;
    @Size(min = 2,message = "Please provide minimum 2 characters")
    private String name;
    private int age;
    private Date dateOfReservation;
    private Date dateOfJourney;

   /* public TicketDetails(String pnrNumber, String name, int age) {
        this.pnrNumber = pnrNumber;
        this.name = name;
        this.age = age;
    }*/

    public TicketDetails(String pnrNumber, String name, int age, Date dateOfReservation, Date dateOfJourney) {
        this.pnrNumber = pnrNumber;
        this.name = name;
        this.age = age;
        this.dateOfJourney = dateOfJourney;
        this.dateOfReservation = dateOfReservation;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfReservation() { return dateOfReservation; }

    public void setDateOfReservation(Date dateOfReservation) { this.dateOfReservation = dateOfReservation; }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }
}
