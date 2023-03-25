package com.example.demo.service;

import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
}
