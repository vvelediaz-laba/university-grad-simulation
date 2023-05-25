package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.collections.LinkedList;
import com.solvd.universitygradsimulation.enums.DegreeType;
import com.solvd.universitygradsimulation.enums.ExtracurricularActivity;
import com.solvd.universitygradsimulation.enums.FacultyRank;
import com.solvd.universitygradsimulation.enums.MajorSubject;
import com.solvd.universitygradsimulation.exceptions.InvalidGradeException;
import com.solvd.universitygradsimulation.exceptions.InvalidNameException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;

public class UniversityGradSimulation {
    private static final Logger logger = LogManager.getLogger(UniversityGradSimulation.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> uniClass = University.class;
        Object university = uniClass.getConstructor().newInstance();
        Method setName = uniClass.getDeclaredMethod("setName", String.class);
        Method setLocation = uniClass.getDeclaredMethod("setLocation", Location.class);
        Method setCampusSize = uniClass.getDeclaredMethod("setCampusSizeAcres", Integer.class);
        Method setRanking = uniClass.getDeclaredMethod("setRanking", Ranking.class);

        setName.invoke(university, "Massachusetts Institute of Technology");
        setLocation.invoke(university, new Location("MIT Main Campus", "77", "Massachusetts Avenue", "Cambridge", "Massachusetts", "02139", "USA"));
        setCampusSize.invoke(university, 168);
        setRanking.invoke(university, new Ranking("Times Higher Education World University Rankings", 5, 2023));

        Consumer<University> printUniversityInfo = uni -> {
            logger.info(uni.getName() + " is " + uni.getCampusSizeAcres() + " acres large and ranks " + uni.getRanking().getRank()
                    + " on " + uni.getRanking().getRankingName());
        };
        printUniversityInfo.accept((University) university);

        Major computerScience = new Major("Computer Science", 120, MajorSubject.COMPUTER_SCIENCE);
        Major economics = new Major("Mathematical Economics", 120, MajorSubject.MATHEMATICS);
        Major biochemistry = new Major("Biochemistry", 120, MajorSubject.BIOLOGY);

        // CS courses for Bob
        LinkedList<Course> csCourses = new LinkedList<>();
        csCourses.add(new Course("Introduction to Computer Science Programming in Python", "6.100A", 6));
        csCourses.add(new Course("Introduction to Low-level Programming in C and Assembly","6.1900", 6));
        csCourses.add(new Course("Discrete Mathematics and Proof for Computer Science","6.120A", 6));
        csCourses.add(new Course("Introduction to Algorithms","6.1210", 12));
        csCourses.add(new Course("Linear Algebra and Optimization","18.C06", 12));
        csCourses.add(new Course("Oral Communication","6.UAT", 12));
        csCourses.add(new Course("Introduction to Probability","6.3700", 12));
        csCourses.add(new Course("Computation Structures","6.1910", 12));
        csCourses.add(new Course("Electrical Circuits: Modeling and Design of Physical Systems","6.2000", 12));
        csCourses.add(new Course("Dynamical System Modeling and Control Design","6.3100", 12));
        csCourses.add(new Course("Engineering for Impact","6.9000", 12));
        csCourses.add(new Course("Hardware Architecture for Deep Learning","6.5931", 12));

        // Econ courses
        LinkedList<Course> econCourses = new LinkedList<>();
        econCourses.add(new Course("Principles of Microeconomics","14.01", 12));
        econCourses.add(new Course("Principles of Macroeconomics","14.02", 12));
        econCourses.add(new Course("Introduction to Statistical Methods in Economics","14.30", 12));
        econCourses.add(new Course("Econometric Data Science","14.32", 12));
        econCourses.add(new Course("Real Analysis","18.100A", 12));
        econCourses.add(new Course("Differential Equations","18.03", 12));
        econCourses.add(new Course("Economic Applications of Game Theory","14.12", 12));
        econCourses.add(new Course("Intermediate Macroeconomics","14.05", 12));
        econCourses.add(new Course("Seminar in Analysis","18.104", 12));
        econCourses.add(new Course("Seminar in Logic","18.504", 12));

        // biochem courses
        LinkedList<Course> bioChemCourses = new LinkedList<>();
        bioChemCourses.add(new Course("Organic Chemistry I","5.12", 12));
        bioChemCourses.add(new Course("Thermodynamics I","5.601", 6));
        bioChemCourses.add(new Course("Fundamentals of Experimental Molecular Biology","7.002", 6));
        bioChemCourses.add(new Course("Genetics","7.03", 12));
        bioChemCourses.add(new Course("Introduction to Chemical Engineering","10.10", 12));
        bioChemCourses.add(new Course("Applied Molecular Biology Laboratory","10.7003[J]", 12));
        bioChemCourses.add(new Course("Differential Equations","18.03", 12));
        bioChemCourses.add(new Course("General Biochemistry","7.05", 12));
        bioChemCourses.add(new Course("Cell Biology","7.06", 12));
        bioChemCourses.add(new Course("Chemical and Biological Engineering Thermodynamics","10.213", 12));
        bioChemCourses.add(new Course("Fluid Mechanics","10.301", 12));
        bioChemCourses.add(new Course("Transport Processes","10.302", 12));

        logger.info("\nBob, Amy, and Sarah have been accepted to MIT, choose one student to simulate, or type none");
        String studentName = "";

        while (true) {
            try {
                logger.info("Enter name: ");
                studentName = scanner.nextLine().toLowerCase();
                if(studentName.equals("none")){
                    break;
                }
                validateName(studentName);
                break;
            } catch (InvalidNameException e) {
                logger.info(e.getMessage());
            }
        }

        if(!studentName.equals("none")){
            LinkedList<Course> simulationCourses = null;
            switch (studentName) {
                case "sarah":
                    simulationCourses = bioChemCourses;
                    logger.info("You have chosen Sarah who is majoring in Biological Chemistry");
                    break;
                case "bob":
                    simulationCourses = csCourses;
                    logger.info("You have chosen Bob who is majoring in Computer Science");
                    break;
                case "amy":
                    simulationCourses = econCourses;
                    logger.info("You have chosen Amy who is majoring in Economics");
                    break;
            }

            for(Course course: simulationCourses){
                while(true){
                    try{
                        String grade;
                        logger.info("Enter grade for " + course.getCourseCode() + " " + course.getName() + ": ");
                        grade = scanner.nextLine().toUpperCase();
                        validateGrade(grade);
                        course.setGrade(grade.charAt(0));
                        break;
                    }catch (InvalidGradeException e){
                        logger.info(e.getMessage());
                    }
                }
            }
        }

        if(studentName.equals("sarah")){
            setRandomGrades(csCourses);
            setRandomGrades(econCourses);
        } else if (studentName.equals("bob")) {
            setRandomGrades(econCourses);
            setRandomGrades(bioChemCourses);
        } else if (studentName.equals("amy")) {
            setRandomGrades(csCourses);
            setRandomGrades(bioChemCourses);
        } else if(studentName.equals("none")){
            setRandomGrades(csCourses);
            setRandomGrades(bioChemCourses);
            setRandomGrades(econCourses);
        }

        Course[] bobCourses = new Course[csCourses.size()];
        bobCourses = csCourses.toArray(bobCourses);

        Course[] amyCourses = new Course[econCourses.size()];
        amyCourses = econCourses.toArray(amyCourses);

        Course[] sarahCourses = new Course[bioChemCourses.size()];
        sarahCourses = bioChemCourses.toArray(sarahCourses);

        Transcript bobTranscript = new Transcript(bobCourses);
        Transcript amyTranscript = new Transcript(amyCourses);
        Transcript sarahTranscript = new Transcript(sarahCourses);

        Student bob = new Student("Bob Smith", "001", 20, computerScience, bobTranscript, DegreeType.BACHELOR, ExtracurricularActivity.CODING_CLUB);
        Student amy = new Student("Amy Johnson", "002", 21, economics, amyTranscript, DegreeType.BACHELOR);
        Student sarah = new Student("Sarah Hernandez", "003", 19, biochemistry, sarahTranscript, DegreeType.BACHELOR, ExtracurricularActivity.DANCE_TEAM);

        bobTranscript.writeToFile("bob_transcript.txt");
        amyTranscript.writeToFile("amy_transcript.txt");
        sarahTranscript.writeToFile("sarah_transcript.txt");

        FacultyMember david = new FacultyMember("David Johnson", 45, new Department("Computer Science"), FacultyRank.PROFESSOR, 100000, true);
        FacultyMember kevin = new FacultyMember("Kevin Sanchez", 50, new Department("Mathematics"), 85000, true);
        FacultyMember anna = new FacultyMember("Anna Scott", 47, new Department("Chemistry"), 82000, true);

        Student[] students = {bob, amy, sarah};
        Staff[] attendees = {david, kevin, anna};

        Method setStudents = uniClass.getDeclaredMethod("setStudents", students.getClass());
        Method setStaff = uniClass.getDeclaredMethod("setStaff", attendees.getClass());
        Method startCeremony = uniClass.getDeclaredMethod("startCeremony", int.class);

        setStudents.invoke(university, (Object) students);
        setStaff.invoke(university, (Object) attendees);
        startCeremony.invoke(university, 2023);
    }

    public static void validateGrade(String grade) throws InvalidGradeException {
        if (!(grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F"))) {
            throw new InvalidGradeException("Invalid grade. Please enter A, B, C, D, or F.");
        }
    }

    public static void validateName(String name) throws InvalidNameException {
        if (!(name.equals("sarah") || name.equals("amy") || name.equals("bob"))){
            throw new InvalidNameException("Invalid name: Please enter a valid name");
        }
    }

    public static char getRandomGrade(){
        Random rand = new Random();
        int num = rand.nextInt(100) + 1;

        if (num <= 70) {
            return 'A';
        } else if (num <= 85) {
            return 'B';
        } else if (num <= 95) {
            return 'C';
        } else if (num <= 99) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void setRandomGrades(LinkedList<Course> courses){
        Consumer<Course> setGrade = course -> {course.setGrade(getRandomGrade());};

        Course[] coursesArray = new Course[courses.size()];
        coursesArray = courses.toArray(coursesArray);

        Arrays.asList(coursesArray).forEach(setGrade);
    }
}
