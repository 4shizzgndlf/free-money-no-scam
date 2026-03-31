package com.example.freemoneynoscam.models;

public class Email {
    private String email;

    public Email(String e) {
        email = e;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        email = e;
    }

    @Override
    public String toString() {
        return email;
    }
}
