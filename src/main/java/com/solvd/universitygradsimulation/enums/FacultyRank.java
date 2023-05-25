package com.solvd.universitygradsimulation.enums;

public enum FacultyRank {
    PROFESSOR("Professor"),
    ASSOCIATE_PROFESSOR("Associate Professor"),
    ASSISTANT_PROFESSOR("Assistant Professor"),
    LECTURER("Lecturer"),
    ADJUNCT_PROFESSOR("Adjunct Professor");

    private final String positionTitle;

    FacultyRank(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getPositionTitle() {
        return positionTitle;
    }
}

