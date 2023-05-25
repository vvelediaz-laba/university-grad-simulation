package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.enums.DegreeType;
import com.solvd.universitygradsimulation.enums.ExtracurricularActivity;
import com.solvd.universitygradsimulation.interfaces.Attendable;
import com.solvd.universitygradsimulation.interfaces.IUniversityMember;

public class Student extends Person implements IUniversityMember, Attendable {
    private String studentId;
    private Major major;
    private Transcript transcript;
    private DegreeType degree;
    private ExtracurricularActivity activity;

    public Student(){

    }

    public Student(String name, String studentId, int age, Major major, Transcript transcript, DegreeType degree, ExtracurricularActivity activity) {
        super(name, age);
        this.studentId = studentId;
        this.major = major;
        this.transcript = transcript;
        this.degree = degree;
        this.activity = activity;
    }

    public Student(String name, String studentId, int age, Major major, Transcript transcript, DegreeType degree) {
        super(name, age);
        this.studentId = studentId;
        this.major = major;
        this.transcript = transcript;
        this.degree = degree;
        this.activity = ExtracurricularActivity.NO_ACTIVITY;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major){
        this.major = major;
    }

    public String getId() {
        return studentId;
    }

    public void setId(String studentId) {
        this.studentId = studentId;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public DegreeType getDegree() {
        return degree;
    }

    public void setDegree(DegreeType degree) {
        this.degree = degree;
    }

    public ExtracurricularActivity getActivity() {
        return activity;
    }

    public void setActivity(ExtracurricularActivity activity) {
        this.activity = activity;
    }

    @Override
    public String toString(){
        return "Name: " + this.getName() + ", ID: " + this.studentId;
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

        Student student = (Student) obj;
        return this.studentId.equals(student.studentId);

    }

    @Override
    public void attend(Ceremony ceremony) {
        Student[] oldGraduates = ceremony.getGraduates();
        Student[] graduates = new Student[oldGraduates.length + 1];
        for(int i = 0; i < oldGraduates.length; i++){
            graduates[i] = oldGraduates[i];
        }

        graduates[oldGraduates.length] = this;
        ceremony.setGraduates(graduates);
    }

    @Override
    public void removeFromUniversity(University university) {
        StudentDirectory newStudents = new StudentDirectory(university.getStudents());
        newStudents.removeStudent(this);
        university.setStudents(newStudents);
        
    }
}
