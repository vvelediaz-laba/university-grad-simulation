package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.interfaces.Clearable;

import java.util.ArrayList;

public class StudentDirectory implements Clearable {
    private ArrayList<Student> students;

    public StudentDirectory() {
        students = new ArrayList<>();
    }

    public StudentDirectory(Student[] students){
        this.students = new ArrayList<>();
        for(Student student: students){
            this.students.add(student);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Student[] getStudents() {
        Student[] studentArr = new Student[students.size()];
        studentArr = students.toArray(studentArr);
        return studentArr;
    }

    @Override
    public void clear() {
        students.clear();
    }
}

