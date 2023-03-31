package com.example.thefed.models;

public class CompleteModel {
    private String spinner;
    private String materialCardView;
    private String aboutme;
    private String ni;
    private String namba;
    private String maile;
    private String spinner2;

    public CompleteModel() {
    }

    public CompleteModel(String spinner, String materialCardView, String aboutme, String ni, String namba, String maile, String spinner2) {
        this.spinner = spinner;
        this.materialCardView = materialCardView;
        this.aboutme = aboutme;
        this.ni = ni;
        this.namba = namba;
        this.maile = maile;
        this.spinner2 = spinner2;
    }

    public String getSpinner() {
        return spinner;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }

    public String getMaterialCardView() {
        return materialCardView;
    }

    public void setMaterialCardView(String materialCardView) {
        this.materialCardView = materialCardView;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getNi() {
        return ni;
    }

    public void setNi(String ni) {
        this.ni = ni;
    }

    public String getNamba() {
        return namba;
    }

    public void setNamba(String namba) {
        this.namba = namba;
    }

    public String getMaile() {
        return maile;
    }

    public void setMaile(String maile) {
        this.maile = maile;
    }

    public String getSpinner2() {
        return spinner2;
    }

    public void setSpinner2(String spinner2) {
        this.spinner2 = spinner2;
    }
}
