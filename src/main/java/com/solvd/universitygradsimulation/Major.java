package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.enums.MajorSubject;

public class Major {
    private String name;
    private Integer requiredCredits;
    private MajorSubject subject;

    public Major(){

    }

    public Major(String name, int requiredCredits, MajorSubject subject) {
        this.name = name;
        this.requiredCredits = requiredCredits;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRequiredCredits() {
        return requiredCredits;
    }

    public void setRequiredCredits(Integer requiredCredits) {
        this.requiredCredits = requiredCredits;
    }

    public MajorSubject getSubject() {
        return subject;
    }

    public void setSubject(MajorSubject subject) {
        this.subject = subject;
    }
}
