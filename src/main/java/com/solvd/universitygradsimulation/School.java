package com.solvd.universitygradsimulation;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Department> departments;
    private List<Major> majors;
    private List<FacultyMember> faculty;
    private List<Student> students;

    public School(){

    }

    public School(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.majors = new ArrayList<>();
        this.faculty = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public List<FacultyMember> getFaculty() {
        return faculty;
    }

    public void setFaculty(List<FacultyMember> faculty) {
        this.faculty = faculty;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
