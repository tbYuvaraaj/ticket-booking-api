package com.project.book.ticket.ticketbookingapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Document
public class TicketDetails {

    @Id
    private String pnrNumber;
    @Size(min = 2,message = "Please provide minimum 2 characters")
    private String name;
    private int age;

    public TicketDetails(String pnrNumber, String name, int age) {
        this.pnrNumber = pnrNumber;
        this.name = name;
        this.age = age;
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
}
