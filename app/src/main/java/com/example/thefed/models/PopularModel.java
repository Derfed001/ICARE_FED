package com.example.thefed.models;

public class PopularModel {
    String name;
    String description;
    String donateamount;
    String totalamount;
    String category;
    String image_url;
    String benefitname;
    String donors;
    String benefitcontact;
    String donationperiod;

    public PopularModel() {
    }

    public PopularModel(String name, String description, String donateamount, String totalamount, String category, String image_url, String benefitname, String donors, String benefitcontact, String donationperiod) {
        this.name = name;
        this.description = description;
        this.donateamount = donateamount;
        this.totalamount = totalamount;
        this.category = category;
        this.image_url = image_url;
        this.benefitname = benefitname;
        this.donors = donors;
        this.benefitcontact = benefitcontact;
        this.donationperiod = donationperiod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDonateamount() {
        return donateamount;
    }

    public void setDonateamount(String donateamount) {
        this.donateamount = donateamount;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getBenefitname() {
        return benefitname;
    }

    public void setBenefitname(String benefitname) {
        this.benefitname = benefitname;
    }

    public String getDonors() {
        return donors;
    }

    public void setDonors(String donors) {
        this.donors = donors;
    }

    public String getBenefitcontact() {
        return benefitcontact;
    }

    public void setBenefitcontact(String benefitcontact) {
        this.benefitcontact = benefitcontact;
    }

    public String getDonationperiod() {
        return donationperiod;
    }

    public void setDonationperiod(String donationperiod) {
        this.donationperiod = donationperiod;
    }
}
