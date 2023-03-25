package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ticket;

    private int hour;
    private int day;
    private int month;
    private int price;
    private int id_train;
    private String class_type;
    private int sit_number;
    private int id_tour;
    private int id_person;

    public Ticket(int hour, int day, int month, int price, int id_train, String class_type, int sit_number, int id_tour, int id_person) {
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.price = price;
        this.id_train = id_train;
        this.class_type = class_type;
        this.sit_number = sit_number;
        this.id_tour = id_tour;
        this.id_person = id_person;
    }

    public Long getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(Long id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId_train() {
        return id_train;
    }

    public void setId_train(int id_train) {
        this.id_train = id_train;
    }

    public String getClass_type() {
        return class_type;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }

    public int getSit_number() {
        return sit_number;
    }

    public void setSit_number(int sit_number) {
        this.sit_number = sit_number;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }
}
