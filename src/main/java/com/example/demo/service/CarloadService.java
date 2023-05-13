package com.example.demo.service;

import com.example.demo.model.Carload;
import com.example.demo.model.Ticket;
import com.example.demo.repository.CarloadRepository;
import com.example.demo.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarloadService {
    @Autowired
    private CarloadRepository carloadRepository;
    @Autowired
    public CarloadService(CarloadRepository carloadRepository){
        this.carloadRepository = carloadRepository;
    }

    public CarloadRepository carloadRepository() {
        return carloadRepository;
    }
    public void setCarloadRepository(CarloadRepository carloadRepository) {
        this.carloadRepository = carloadRepository;
    }

    public List<Carload> CarloadsFindAll(){
        return carloadRepository.findAll();
    }
    public void carloadDeleteAll(){
        carloadRepository.deleteAll();
    }

    public Carload createCarload(Carload carload){
        return carloadRepository.save(carload);
    }

    public Carload updateById(Long id,Carload carload){
        Optional<Carload> updateTicket = carloadRepository.findById(id);
        long id_carload = carload.getId_carload();
        int id_train = carload.getId_train();
        int number_sits = carload.getNumber_sits();
        String class_type = carload.getClass_type();

        return carloadRepository.save(carload);
    }

    public Carload findById(Long id_carload){
        Optional<Carload> optionalCarload = carloadRepository.findById(id_carload);
        if(optionalCarload.isPresent()){
            return optionalCarload.get();
        }else {
            throw new EntityNotFoundException("ticket with id "+id_carload+ "not found");
        }
    }
    public void deleteById(Long id_carload){
        Optional<Carload> optionalCarload = carloadRepository.findById(id_carload);
        if(optionalCarload.isPresent()){
            carloadRepository.deleteById(id_carload);
        }else {
            throw new EntityNotFoundException("train with id "+id_carload+"not found");
        }
    }
}
