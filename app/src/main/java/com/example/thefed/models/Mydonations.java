package com.example.thefed.models;

public class Mydonations {
    String name;
    String donateamount;
    String category;
    String benefitname;

    public Mydonations() {
    }

    public Mydonations(String name, String donateamount, String category, String benefitname) {
        this.name = name;
        this.donateamount = donateamount;
        this.category = category;
        this.benefitname = benefitname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDonateamount() {
        return donateamount;
    }

    public void setDonateamount(String donateamount) {
        this.donateamount = donateamount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBenefitname() {
        return benefitname;
    }

    public void setBenefitname(String benefitname) {
        this.benefitname = benefitname;
    }
}