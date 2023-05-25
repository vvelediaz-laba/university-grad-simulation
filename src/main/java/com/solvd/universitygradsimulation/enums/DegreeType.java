package com.solvd.universitygradsimulation.enums;

public enum DegreeType {
    BACHELOR("Bachelor's"),
    MASTER("Master's"),
    DOCTORATE("Doctorate"),
    ASSOCIATE("Associate");

    private final String degreeName;

    DegreeType(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getDegreeName() {
        return degreeName;
    }
}
