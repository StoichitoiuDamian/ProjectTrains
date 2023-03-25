package com.example.demo.service;

import com.example.demo.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TourService {
    @Autowired
    private TourRepository tourRepository;
}
