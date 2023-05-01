package com.example.demo.model;


import com.example.demo.observer.NewTrainInformation;
import com.example.demo.observer.TrainNews;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Aceasta clasa reprezintă modelul de bază al unei persoane,
 * cu proprietăți precum ID-ul persoanei, numele de utilizator și parola. De asemenea, clasa are adnotarea
 * "@Id" pentru a indica faptul că id_person este cheia primară a tabelului corespunzător acestei clase.
 * Adnotarea "@GeneratedValue" specifică modul de generare a valorii ID-ului în cazul în care nu este furnizat manual.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_person;


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


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
