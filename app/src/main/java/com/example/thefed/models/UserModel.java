package com.example.thefed.models;

public class UserModel {
    String email;
    String password;
    String fullname;
    String contact;

    public UserModel() {
    }

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
