package com.example.thefed.models;

public class MoreModel {
    String name;
    String image_url;
    String descript;
    String benname;
    String bencontact;
    int totalamount;
    int days;

    public MoreModel() {

    }

    public MoreModel(String name, String image_url, String descript, String benname, String bencontact, int totalamount, int days) {
        this.name = name;
        this.image_url = image_url;
        this.descript = descript;
        this.benname = benname;
        this.bencontact = bencontact;
        this.totalamount = totalamount;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getBenname() {
        return benname;
    }

    public void setBenname(String benname) {
        this.benname = benname;
    }

    public String getBencontact() {
        return bencontact;
    }

    public void setBencontact(String bencontact) {
        this.bencontact = bencontact;
    }

    public int getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
