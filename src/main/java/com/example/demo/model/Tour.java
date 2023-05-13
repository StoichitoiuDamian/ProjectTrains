package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Această clasă reprezintă un tur de tren, care are anumite atribute ca o oră, o zi și o lună specifice, ora de pornire și sosire,
 * id-ul trenului, id-ul turului etc. Aceasta are un constructor care primește aceste atribute și getteri și setteri pentru fiecare atribut.
 * De asemenea, clasa are o cheie primară (id_tour) care este generată automat prin utilizarea anotării @GeneratedValue.
 */
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tour;
    private int hour;
    private int day;
    private int month;
    private String start;
    private String stop;
    private int id_train;



    public int getHour() {
        return hour;
    }

    public Long getId_tour() {
        return id_tour;
    }

    public void setId_tour(Long id_tour) {
        this.id_tour = id_tour;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public int getId_train() {
        return id_train;
    }

    public void setId_train(int id_train) {
        this.id_train = id_train;
    }
}
