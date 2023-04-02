package com.example.demo.controller;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

public class TrainController {
    @Autowired
    TrainService trainService;

    @GetMapping("/train")
    public List<Train> getMapping(){
        return trainService.trainFindAll();
    }
    @DeleteMapping("/deleteTrain")
    public void deleteTrain(){
        trainService.trainDeleteAll();
    }

   @PostMapping("/postTrain")
   public Train createTrain(@RequestBody Train train){
       return trainService.createTrain(train);
   }
   @PutMapping("/putTrain{id}")
    public Train updateTrain(@PathVariable Long id,@RequestBody Train train){
       return trainService.updateById(id,train);
   }
   @GetMapping("/findTrain{id}")
   public Train findById(@PathVariable Long id){
        Train t1 = new Train();

        try{
             t1 = trainService.findById(id);
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
    @DeleteMapping("/deleteTrain{id}")
   public void deleteById(@PathVariable Long id){
        trainService.deleteById(id);
   }
}
