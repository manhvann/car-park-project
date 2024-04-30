package com.example.carparkproject.controller;

import com.example.carparkproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket")
    public ResponseEntity<?> getList(){
       return ResponseEntity.ok().body(ticketService.getAllTickets());
    }
}
