package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Această clasă reprezintă o entitate de tip tren. Are un câmp de identificare id_train generat automat de baza de date. De asemenea,
 * conține informații despre numele trenului train_name, tipul trenului train_type și identificatorul turului id_tour.
 * De asemenea, clasa are metode pentru a seta și prelua valorile acestor câmpuri.
 */
@Entity

public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_train;

    private String train_name;
    private String train_type;
    private Long id_tour;

    public Long getId_train() {
        return id_train;
    }

    public String getTrain_name() {
        return train_name;
    }

    public String getTrain_type() {
        return train_type;
    }

    public Long getId_tour() {
        return id_tour;
    }

    public void setId_train(Long id_train) {
        this.id_train = id_train;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }

    public void setId_tour(Long id_tour) {
        this.id_tour = id_tour;
    }
}
