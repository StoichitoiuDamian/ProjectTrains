package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carload {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_carload;
    private int id_train;
    private int number_sits;
    private String class_type;

    public Carload(int id_train, int number_sits, String class_type) {
        this.id_train = id_train;
        this.number_sits = number_sits;
        this.class_type = class_type;
    }

    public Long getId_carload() {
        return id_carload;
    }

    public void setId_carload(Long id_carload) {
        this.id_carload = id_carload;
    }

    public int getId_train() {
        return id_train;
    }

    public void setId_train(int id_train) {
        this.id_train = id_train;
    }

    public int getNumber_sits() {
        return number_sits;
    }

    public void setNumber_sits(int number_sits) {
        this.number_sits = number_sits;
    }

    public String getClass_type() {
        return class_type;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }
}
