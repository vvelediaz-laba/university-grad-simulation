package com.solvd.universitygradsimulation;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.solvd.universitygradsimulation.interfaces.IFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ceremony extends Event{
    private static final Logger logger = LogManager.getLogger(Ceremony.class.getName());

    private Student[] graduates;
    private Staff[] staffAttendees;

    public Ceremony(){

    }

    public Ceremony(int year){
        super("Graduation " + year, "A ceremony to honor students who completed all requirements");
        graduates = new Student[0];
        staffAttendees = new Staff[0];
    }

    public Ceremony(int year, Student[] graduates, Staff[] staffAttendees) {
        super("Graduation " + year, "A ceremony to honor students who completed all requirements");
        this.graduates = graduates;

        ArrayList<Staff> staffAttending = new ArrayList<>();
        for(Staff staff: staffAttendees){
            if(staff.getAttendee()){
                staffAttending.add(staff);
            }
        }

        this.staffAttendees = staffAttending.toArray(staffAttendees);
    }

    public Student[] getGraduates() {
        return graduates;
    }

    public void setGraduates(Student[] graduates) {
        this.graduates = graduates;
    }

    public Staff[] getStaffAttendees() {
        return staffAttendees;
    }

    public void setStaffAttendees(Staff[] staffAttendees) {
        this.staffAttendees = staffAttendees;
    }

    public void startEvent(){

        Predicate<Double> passingGrade = num -> num >= 2.0;

        IFilter<Student> passingGpa = (Student student) -> {
            boolean passed = passingGrade.test(student.getTranscript().getGpa());
            if(!passed) logger.info(student + " did not graduate\n");
            return passed;
        };

        for(Student graduate : Arrays.stream(graduates).filter(passingGpa::filter).collect(Collectors.toList())){
            GraduateUtils.graduateStudent(graduate);
        }

        logger.info(this.getName() + " has started!");
        logger.info("Current staff attendees: ");
        for(Staff attendee : staffAttendees){
            if(attendee != null){
                logger.info(attendee.getName());
            }
        }

        for(Alumni alumni: GraduateUtils.getGraduates()){
            logger.info(alumni.getName() + " has graduated with gpa " + String.format("%.2f", alumni.getTranscript().getGpa()));
        }
    }
}
