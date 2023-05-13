package com.example.demo.controller;

import com.example.demo.model.Tour;
import com.example.demo.model.Train;
import com.example.demo.service.TourService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TourController {
    @Autowired
    private TourService tourService;
    @GetMapping("/tour")
    public List<Tour> getMapping(){
        return tourService.toursFindAll();
    }
    @DeleteMapping("/deleteTour")
    public void deleteTour(){
        tourService.tourDeleteAll();
    }

    @PostMapping("/postTour")
    public Tour createTour(@RequestBody Tour tour){
        return tourService.createTour(tour);
    }
    @PutMapping("/putTour{id}")
    public Tour updateTour(@PathVariable Long id,@RequestBody Tour tour){
        return tourService.updateById(id,tour);
    }
    @GetMapping("/findTour{id}")
    public Tour findById(@PathVariable Long id){
        Tour t1 = new Tour();

        try{
            t1 = tourService.findById(id);
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
    @DeleteMapping("/deleteTour{id}")
    public void deleteById(@PathVariable Long id){
        tourService.deleteById(id);
    }
}
