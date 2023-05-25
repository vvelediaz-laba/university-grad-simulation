package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.interfaces.IAverage;
import com.solvd.universitygradsimulation.interfaces.IList;
import com.solvd.universitygradsimulation.interfaces.Writeable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Transcript implements Writeable {
    private static final Logger logger = LogManager.getLogger(Transcript.class.getName());

    private Course[] courses;

    public Transcript(){

    }

    public Transcript(Course[] courses) {
        this.courses = courses;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public double getGpa(){
        IAverage<Double> getAverage = (list) -> list
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        return getAverage.average(this.getGrades());
    }

    public int getCreditHours(){
        List<Integer> creditsList = Arrays.stream(courses)
                                            .map(Course::getCreditHours)
                                            .collect(Collectors.toList());

        return creditsList.stream()
                .reduce(0, Integer::sum);
    }

    public List<Double> getGrades(){
        IList<Double, Course> createGradeList = (List<Course> courses) -> courses
                .stream()
                .map(course -> (double)course.getGrade().getValue())
                .collect(Collectors.toList());

        return createGradeList.toList(Arrays.asList(this.courses));
    }

    @Override
    public void writeToFile(String fileName) {
        try(FileWriter transcriptWriter = new FileWriter(fileName)){
            Consumer<Course> writeToFile = course -> {
                try {
                    transcriptWriter.write(course.getCourseCode() + " - " + course.getName() + ": " + course.getGrade() + "\n");
                } catch (IOException e){
                    logger.error("An error occurred while writing transcripts to file");
                }
            };
            Arrays.asList(courses).forEach(writeToFile);

            Function<Double, String> twoDecimalPlaces = number -> String.format("%.2f", number);

            transcriptWriter.write("\nGPA: " + twoDecimalPlaces.apply(getGpa()));
        }catch (IOException e){
            logger.error("An error occurred while writing transcripts to file");
        }
    }
}
