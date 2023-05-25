package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.interfaces.Attendable;
import com.solvd.universitygradsimulation.interfaces.Employable;
import com.solvd.universitygradsimulation.interfaces.IUniversityMember;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Staff extends Person implements Employable, Attendable, IUniversityMember {
    private static final Logger logger = LogManager.getLogger(Staff.class.getName());

    private String jobTitle;
    private Integer salary;
    private String staffId;
    private Boolean isAttendee;

    public Staff(){

    }

    public Staff(String name, Integer age) {
        super(name, age);
    }

    public Staff(String name, Integer age, String jobTitle, Integer salary, boolean isAttendee){
        super(name, age);
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.isAttendee = isAttendee;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getId() {
        return staffId;
    }

    public void setId(String staffId) {
        this.staffId = staffId;
    }

    public Boolean getAttendee() {
        return isAttendee;
    }

    public void setAttendee(Boolean attendee) {
        isAttendee = attendee;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", ID: " + getId();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Staff staff = (Staff) obj;
        return this.getId().equals(staff.getId());
    }

    @Override
    public void attend(Ceremony ceremony) {
        Staff[] oldStaff = ceremony.getStaffAttendees();
        Staff[] newStaff = new Staff[oldStaff.length + 1];
        for(int i = 0; i < oldStaff.length; i++){
            newStaff[i] = oldStaff[i];
        }

        newStaff[oldStaff.length] = this;
        ceremony.setStaffAttendees(newStaff);
    }

    @Override
    public void showEmploymentInfo() {
        logger.info(getName() + " is currently a " + jobTitle + " making " + getSalary() + " a year");
    }

    @Override
    public void removeFromUniversity(University university) {
        StaffDirectory newStaff = new StaffDirectory(university.getStaff());
        newStaff.removeStaff(this);
        university.setStaff(newStaff);
    }
}
