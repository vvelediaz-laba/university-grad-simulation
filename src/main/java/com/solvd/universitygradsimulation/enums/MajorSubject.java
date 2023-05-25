package com.solvd.universitygradsimulation.enums;

public enum MajorSubject {
    MATHEMATICS("Mathematics"),
    COMPUTER_SCIENCE("Computer Science"),
    BIOLOGY("Biology"),
    CHEMISTRY("Chemistry"),
    ENGLISH("English"),
    HISTORY("History"),
    PSYCHOLOGY("Psychology"),
    BUSINESS("Business"),
    ENGINEERING("Engineering"),
    ART("Art");

    private final String displayName;

    MajorSubject(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

