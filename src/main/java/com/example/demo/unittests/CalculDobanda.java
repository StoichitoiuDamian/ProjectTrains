package com.example.demo.unittests;

import static com.example.demo.unittests.Risc.*;

public class CalculDobanda {

   private OperatiiBazaDeDate op;


    public CalculDobanda(OperatiiBazaDeDate op) {
        this.op = op;
    }
    public CalculDobanda(){

    }

    public  double dobanda(TypeDobanda dobanda) {
        double valoare=0;
        switch (dobanda) {
            case MARE -> valoare = 2;
            case MEDIE -> valoare = 1;
            case MICA -> valoare = 0.5;
        }
        return valoare;
    }
    public  double returneazaDobanda(User user){
        double val = 0;
        switch (user.getRisc()) {
            case RIDICAT -> val = dobanda(TypeDobanda.MARE);
            case MEDIU -> val = dobanda(TypeDobanda.MEDIE);
            case SCAZUT -> val = dobanda(TypeDobanda.MICA);
        }
        return val;
    }
    public double calculDobanda(){//user nou creat si ii returnez o noua dobanda
        User newUser =  op.getUser();
        return returneazaDobanda(newUser);
    }
}
