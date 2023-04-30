package com.example.demo.unittests;

public class OperatiiBazaDeDateMoc implements OperatiiBazaDeDate{
    @Override
    public User getUser() {
        return new User("Mircea Popescu",Risc.MEDIU);
    }
}
