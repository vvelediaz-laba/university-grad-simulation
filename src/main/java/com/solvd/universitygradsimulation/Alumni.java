package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.interfaces.Employable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Alumni extends Student implements Employable {
    private static final Logger logger = LogManager.getLogger(Student.class.getName());

    private Integer graduationYear;
    private String employmentStatus;

    public Alumni(){

    }

    public Alumni(Student student, int graduationYear){
        super(student.getName(), student.getId(), student.getAge(), student.getMajor(),student.getTranscript(), student.getDegree(), student.getActivity());
        this.graduationYear = graduationYear;
        this.employmentStatus = "New Grad";
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    @Override
    public void showEmploymentInfo() {
        logger.info(getName() + " is currently a " + employmentStatus);
    }
}
