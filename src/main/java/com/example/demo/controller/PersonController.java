package com.example.demo.controller;


import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PersonController {
    @Autowired
    private PersonService personService;

    public void news(String info){
        personService.update(info);
    }
}
