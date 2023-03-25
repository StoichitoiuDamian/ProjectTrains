package com.example.demo.service;

import com.example.demo.repository.CarloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarloadService {
    @Autowired
    private CarloadRepository carloadRepository;
}
