package com.example.thefed.models;

public class FindDonorModel {
    String name;
    String email;
    String contact;
    String Interests;

    public FindDonorModel() {
    }

    public FindDonorModel(String name, String email, String contact, String interests) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        Interests = interests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInterests() {
        return Interests;
    }

    public void setInterests(String interests) {
        Interests = interests;
    }
}
