package com.solvd.universitygradsimulation;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public final class GraduateUtils {
    private static ArrayList<Alumni> graduates = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(GraduateUtils.class.getName());


    public static boolean canGraduate(Student student){
        if(student.getTranscript().getCreditHours() >= student.getMajor().getRequiredCredits()){
            return student.getTranscript().getGpa() >= 2.0;
        }
        logger.info(student.toString() + " did not graduate\n");
        return false;
    }

    public static void graduateStudent(Student student){
        graduates.add(new Alumni(student, 2023));
    }

    public static Alumni[] getGraduates() {
        Alumni[] alumni = new Alumni[graduates.size()];
        alumni = graduates.toArray(alumni);
        return alumni;
    }
}
