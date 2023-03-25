package com.example.demo.controller;

import com.example.demo.service.CarloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CarloadController {
    @Autowired
    private CarloadService carloadService;
}
