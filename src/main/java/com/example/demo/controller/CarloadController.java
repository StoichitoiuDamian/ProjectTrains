package com.example.demo.controller;

import com.example.demo.model.Carload;
import com.example.demo.model.Ticket;
import com.example.demo.service.CarloadService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarloadController {
    @Autowired
    private CarloadService carloadService;
    @GetMapping("/Carload")
    public List<Carload> getMapping(){
        return carloadService.CarloadsFindAll();
    }
    @DeleteMapping("/deleteCarload")
    public void deleteCarload(){
        carloadService.carloadDeleteAll();
    }

    @PostMapping("/postCarload")
    public Carload createCarload(@RequestBody Carload carload){
        return carloadService.createCarload(carload);
    }
    @PutMapping("/putCarload{id}")
    public Carload updateCarload(@PathVariable Long id,@RequestBody Carload carload){
        return carloadService.updateById(id,carload);
    }
    @GetMapping("/findCarload{id}")
    public Carload findById(@PathVariable Long id){
        Carload t1 = new Carload();

        try{
            t1 = carloadService.findById(id);
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
    @DeleteMapping("/deleteCarload{id}")
    public void deleteById(@PathVariable Long id){
        carloadService.deleteById(id);
    }
}
