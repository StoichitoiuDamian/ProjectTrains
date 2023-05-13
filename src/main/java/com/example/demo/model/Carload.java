package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Această clasă definește un model de date pentru un tip de marfă feroviară numit "Carload". Aceasta are următoarele proprietăți:
 *
 * id_carload: un identificator unic pentru această instanță de tip Carload
 * id_train: id-ul trenului cu care este asociat acest Carload
 * number_sits: numărul de locuri disponibile în acest Carload
 * class_type: tipul de clasă pentru locuri (ex. Business, Economy)
 * De asemenea, clasa conține un constructor cu parametrii necesari pentru a crea un nou obiect Carload și metode de acces și modificare pentru fiecare proprietate.
 */
@Entity
public class Carload {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_carload;
    private int id_train;
    private int number_sits;
    private String class_type;



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
