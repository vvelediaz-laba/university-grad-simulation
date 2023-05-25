package com.solvd.universitygradsimulation;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Major> majors;
    private FacultyMember departmentHead;

    public Department(){

    }

    public Department(String name) {
        this.name = name;
        this.majors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public FacultyMember getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentChair(FacultyMember departmentHead) {
        this.departmentHead = departmentHead;
    }
}

