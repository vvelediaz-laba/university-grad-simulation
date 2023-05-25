package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.interfaces.Clearable;

import java.util.List;

public class University implements Clearable {
    private String name;
    private Location location;
    private Integer campusSizeAcres;
    private StudentDirectory students;
    private StaffDirectory staff;
    private List<School> schools;
    private Ranking ranking;

    public University(){

    }

    public University(String name, Student[] students, Staff[] staff) {
        this.name = name;
        this.students = new StudentDirectory(students);
        this.staff = new StaffDirectory(staff);
    }

    public Student[] getStudents() {
        return (Student[]) students.getStudents();
    }

    public void setStudents(Student[] students) {
        this.students = new StudentDirectory(students);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Staff[] getStaff() {
        return (Staff[]) staff.getStaff();
    }

    public void setStaff(Staff[] staff) {
        this.staff = new StaffDirectory(staff);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getCampusSizeAcres() {
        return campusSizeAcres;
    }

    public void setCampusSizeAcres(Integer campusSizeAcres) {
        this.campusSizeAcres = campusSizeAcres;
    }

    public void setStudents(StudentDirectory students) {
        this.students = students;
    }

    public void setStaff(StaffDirectory staff) {
        this.staff = staff;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public void startCeremony(int year){
        Ceremony ceremony = new Ceremony(year);
        for(Student student: getStudents()){
            student.attend(ceremony);
        }
        for(Staff staff: getStaff()){
            staff.attend(ceremony);
        }
        ceremony.startEvent();
    }

    @Override
    public void clear() {
        students.clear();
        staff.clear();
    }
}
