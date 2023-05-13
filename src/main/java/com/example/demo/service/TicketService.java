package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.model.Tour;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.TourRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public TicketRepository getTourRepository() {
        return ticketRepository;
    }
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> ticketsFindAll(){
        return ticketRepository.findAll();
    }
    public void ticketDeleteAll(){
        ticketRepository.deleteAll();
    }

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket updateById(Long id,Ticket ticket){
        Optional<Ticket> updateTicket = ticketRepository.findById(id);
        long id_ticket = ticket.getId_ticket();
        int hour = ticket.getHour();
        int day = ticket.getDay();
        int month = ticket.getMonth();
        int price = ticket.getPrice();
        int id_train = ticket.getId_train();
        String class_type = ticket.getClass_type();
        int sit_number = ticket.getSit_number();
        int id_tour = ticket.getId_tour();
        int id_person = ticket.getId_person();


        return ticketRepository.save(ticket);
    }

    public Ticket findById(Long id_ticket){
        Optional<Ticket> optionalTicket = ticketRepository.findById(id_ticket);
        if(optionalTicket.isPresent()){
            return optionalTicket.get();
        }else {
            throw new EntityNotFoundException("ticket with id "+id_ticket+ "not found");
        }
    }
    public void deleteById(Long id_ticket){
        Optional<Ticket> optionalTicket = ticketRepository.findById(id_ticket);
        if(optionalTicket.isPresent()){
            ticketRepository.deleteById(id_ticket);
        }else {
            throw new EntityNotFoundException("train with id "+id_ticket+"not found");
        }
    }
}
