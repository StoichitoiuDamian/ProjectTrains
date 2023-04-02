package com.example.demo.service;


import com.example.demo.observer.NewTrainInformation;
import com.example.demo.observer.TrainNews;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements NewTrainInformation {

    @Autowired
    private PersonRepository personRepository;

    TrainNews trainNews;
    @Override
    public void update(String news) {
        trainNews.setNews(news);
    }
}
