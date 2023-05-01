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

/**
 * Această clasă este un controler Spring pentru API-ul legat de trenuri. Are mai multe metode, fiecare cu o anumită acțiune specifică.
 * Metodele sunt etichetate cu diferite tipuri de solicitări HTTP (cum ar fi GET, POST, DELETE și PUT) și URL-uri corespunzătoare. Acestea sunt câteva dintre funcțiile controlerului:
 *
 * getMapping() - returnează o listă de toate trenurile disponibile prin apelul metodei trainFindAll() din clasa TrainService.
 * deleteTrain() - elimină toate trenurile din sistem prin apelul metodei trainDeleteAll() din clasa TrainService.
 * createTrain() - crează un tren nou prin apelul metodei createTrain() din clasa TrainService.
 * updateTrain() - actualizează un tren existent prin apelul metodei updateById() din clasa TrainService, pe baza ID-ului trenului și a noilor detalii ale trenului.
 * findById() - caută un tren existent după ID prin apelul metodei findById() din clasa TrainService.
 * deleteById() - elimină un tren existent după ID-ul său prin apelul metodei deleteById() din clasa TrainService.
 */
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
