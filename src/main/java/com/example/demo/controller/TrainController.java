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

   /** @PostMapping("/saveTrain")
    public Train saveTrain(@RequestBody Train train){
        Train newTrain = new Train();
       newTrain.setTrain_name(train.getTrain_name());
       newTrain.setTrain_type(train.getTrain_type());

       return trainRepository.save(newTrain);
    }
    @PutMapping("/updateTrain")
    public Train updateTrain(@RequestBody Train train){
        Optional<Train> updateTrain = trainRepository.findById(train.getId_train());
        Train newTrain = updateTrain.get();
        newTrain.setTrain_name(train.getTrain_name());

        return trainRepository.save(newTrain);
    }
    @PostMapping("/post")
    public void createTrain(Train train){
    trainService.createTrain(train);
    **/
   /**
   @PostMapping("/post")
    public Train createTrain(@RequestBody Train train){
        return trainRepository.save(train);
   }
   **/

   @PostMapping("/post")
   public Train createTrain(@RequestBody Train train){
       return trainService.createTrain(train);
   }
   @PutMapping("/put{id}")
    public Train updateTrain(@PathVariable Long id,@RequestBody Train train){
       return trainService.updateById(id,train);
   }
}
