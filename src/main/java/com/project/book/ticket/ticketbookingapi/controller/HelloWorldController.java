package com.project.book.ticket.ticketbookingapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/test")
    public String sample(){
        return "Good Morning..";
    }
}
