package com.example.demo.controller;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;
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
    TrainRepository trainRepository;

    @GetMapping("/")
    public List<Train> getMapping(){
        return trainService.trainFindAll();
    }
    @DeleteMapping("/delete")
    public void deleteTrain(){
        trainService.trainDeleteAll();
    }

   @PostMapping("/post")
   public Train createTrain(@RequestBody Train train){
       return trainService.createTrain(train);
   }
   @PutMapping("/put{id}")
    public Train updateTrain(@PathVariable Long id,@RequestBody Train train){
       return trainService.updateById(id,train);
   }
}
