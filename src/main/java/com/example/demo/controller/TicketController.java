package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.model.Tour;
import com.example.demo.service.TicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @GetMapping("/ticket")
    public List<Ticket> getMapping(){
        return ticketService.ticketsFindAll();
    }
    @DeleteMapping("/deleteTicket")
    public void deleteTicket(){
        ticketService.ticketDeleteAll();
    }

    @PostMapping("/postTicket")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }
    @PutMapping("/putTicket{id}")
    public Ticket updateTicket(@PathVariable Long id,@RequestBody Ticket ticket){
        return ticketService.updateById(id,ticket);
    }
    @GetMapping("/findTicket{id}")
    public Ticket findById(@PathVariable Long id){
        Ticket t1 = new Ticket();

        try{
            t1 = ticketService.findById(id);
        }
        catch (EntityNotFoundException e2){
            System.out.println("Entity not found");
        }
        catch (Exception e){
            t1 = null;
            System.out.println("Exception found");
        }

        return t1;
    }
    @DeleteMapping("/deleteTicket{id}")
    public void deleteById(@PathVariable Long id){
        ticketService.deleteById(id);
    }
}
