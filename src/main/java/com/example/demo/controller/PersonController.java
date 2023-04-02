package com.example.demo.controller;


import com.example.demo.model.Person;
import com.example.demo.model.Train;
import com.example.demo.observer.TrainNews;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public List<Person> showPerson(){
        return personService.personFindAll();
    }

    @DeleteMapping("/deletePerson")
    public void deletePerson(){
        personService.personDeleteAll();
    }

    @PostMapping("/postPerson")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
    @PutMapping("/putPerson{id}")
    public Person updatePerson(@PathVariable Long id,@RequestBody Person person){
        return personService.updateById(id,person);
    }
    @GetMapping("/getNews")
    public void getNews(String news){
        personService.update(news);
    }
}
