package com.example.demo.controller;

import com.example.demo.model.Train;
import com.example.demo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin

public class TrainController {
    @Autowired
    TrainService trainService;

    @GetMapping("/")
    public List<Train> getMapping(){
        return trainService.trainList();
    }
    @DeleteMapping("/delete")
    public void deleteTrain(){
        trainService.trainDelete();
    }
}
