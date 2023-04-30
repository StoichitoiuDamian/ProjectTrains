package com.example.demo.unittests;

public class User {
    private String username;
    private Risc risc;

    public User(String username, Risc risc) {
        this.username = username;
        this.risc = risc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Risc getRisc() {
        return risc;
    }

    public void setRisc(Risc risc) {
        this.risc = risc;
    }
}
