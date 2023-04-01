package com.example.demo.model;


import com.example.demo.observer.NewTrainInformation;
import com.example.demo.observer.TrainNews;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person implements NewTrainInformation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_person;
    TrainNews trainNews;
    private String news;
    private String username;
    private String password;

    public Long getId_person() {
        return id_person;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }
    @Override
    public void update(String news) {
        trainNews.setNews(news);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
