package com.example.demo;

import com.example.demo.model.Ticket;
import com.example.demo.model.Tour;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class TestEndPointsTicket {
    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;



    private Ticket ticket1;
    private Ticket ticket2;
    private List<Ticket> ticketList;



    @BeforeEach
    public void setUp() {
        ticket1 = new Ticket();
        ticket1.setId_ticket(1L);
        ticket1.setHour(20);
        ticket1.setDay(20);
        ticket1.setMonth(12);
        ticket1.setId_train(1);
        ticket1.setPrice(1);
        ticket1.setClass_type("First Class");
        ticket1.setSit_number(1);
        ticket1.setId_tour(1);
        ticket1.setId_person(1);

        ticket1 = new Ticket();
        ticket1.setId_ticket(1L);
        ticket1.setHour(20);
        ticket1.setDay(20);
        ticket1.setMonth(12);
        ticket1.setId_train(1);
        ticket1.setPrice(1);
        ticket1.setClass_type("Second");
        ticket1.setSit_number(1);
        ticket1.setId_tour(1);
        ticket1.setId_person(1);

        ticketList = new ArrayList<>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);
    }

    @Test
    public void testTicketFindAll() {
        when(ticketRepository.findAll()).thenReturn(ticketList);
        List<Ticket> foundTicket = ticketService.ticketsFindAll();
        assertEquals(2, foundTicket.size());
        assertEquals(ticketList, foundTicket);
    }

    @Test
    public void testTicketDeleteAll() {
        ticketService.ticketDeleteAll();
        verify(ticketRepository, times(1)).deleteAll();
    }

    @Test
    public void testCreateTicket() {
        when(ticketRepository.save(ticket1)).thenReturn(ticket1);
        Ticket createdTicket = ticketService.createTicket(ticket1);
        assertEquals(ticket1, createdTicket);
    }
    @Test
    public void testUpdateById() {
        Optional<Ticket> optionalTicket = Optional.of(ticket1);
        when(ticketRepository.findById(1L)).thenReturn(optionalTicket);
        when(ticketRepository.save(ticket1)).thenReturn(ticket1);
        Ticket updatedTicket = ticketService.updateById(1L, ticket1);
        assertEquals(ticket1, updatedTicket);
    }
    @Test
    public void testFindById() {
        Optional<Ticket> optionalTicket = Optional.of(ticket1);
        when(ticketRepository.findById(1L)).thenReturn(optionalTicket);
        Ticket foundTicket = ticketService.findById(1L);
        assertEquals(ticket1, foundTicket);
    }

    @Test
    public void testDeleteById() {
        Optional<Ticket> optionalTicket = Optional.of(ticket1);
        when(ticketRepository.findById(1L)).thenReturn(optionalTicket);
        ticketService.deleteById(1L);
        verify(ticketRepository, times(1)).deleteById(1L);
    }
}
