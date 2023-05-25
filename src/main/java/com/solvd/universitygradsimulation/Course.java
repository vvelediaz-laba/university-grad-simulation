package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.enums.Grade;

public class Course {
    private String name;
    private String courseCode;
    private Integer creditHours;
    private Grade grade;

    public Course(){

    }

    public Course(String name, String courseCode, int creditHours, Grade grade) {
        this.name = name;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.grade = grade;
    }

    public Course(String name, String courseCode, int creditHours) {
        this.name = name;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setGrade(Character grade) {
        switch (grade){
            case 'A':
                this.setGrade(Grade.A);
                break;
            case 'B':
                this.setGrade(Grade.B);
                break;
            case 'C':
                this.setGrade(Grade.C);
                break;
            case 'D':
                this.setGrade(Grade.D);
                break;
            case 'F':
                this.setGrade(Grade.F);
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditHours(Integer creditHours) {
        this.creditHours = creditHours;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
