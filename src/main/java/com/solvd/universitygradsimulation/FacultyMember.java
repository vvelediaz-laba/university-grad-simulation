package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.enums.FacultyRank;

public class FacultyMember extends Staff{
    private Department department;
    private FacultyRank rank;

    public FacultyMember(){
        this.rank = FacultyRank.LECTURER;
        this.setJobTitle(rank.getPositionTitle());
        this.setSalary(50000);
        this.setAttendee(false);
    }

    public FacultyMember(String name, Integer age, FacultyRank rank) {
        super(name, age, rank.getPositionTitle(), 50000, false);
        this.rank = rank;
    }

    public FacultyMember(String name, Integer age,  Department department, Integer salary, boolean isAttendee) {
        super(name, age, FacultyRank.LECTURER.getPositionTitle(), salary, isAttendee);
        this.department = department;
        this.rank = FacultyRank.LECTURER;
    }

    public FacultyMember(String name, Integer age,  Department department, FacultyRank rank, Integer salary, boolean isAttendee) {
        super(name, age, rank.getPositionTitle(), salary, isAttendee);
        this.department = department;
        this.rank = rank;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
