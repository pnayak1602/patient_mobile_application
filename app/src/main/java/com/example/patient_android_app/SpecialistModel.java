package com.example.patient_android_app;

public class SpecialistModel {

    int image;
    String title, desc, prob;

    public SpecialistModel(int image, String title, String desc, String prob) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.prob = prob;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getProb() {
        return prob;
    }

}