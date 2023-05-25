package com.solvd.universitygradsimulation.filestringutils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class UniqueWords {

    public static void main(String[] args) throws IOException{
        getUniqueWords();
    }

    public static void getUniqueWords() throws IOException {
        String fileContents = StringUtils.remove(FileUtils.readFileToString(new File("src/main/resources/sample.txt"), Charset.forName("UTF-8")), '.');
        Map<String, Integer> words = new HashMap<>();

        for(String value : StringUtils.split(fileContents)){
            if(words.containsKey(value)){
                words.replace(value, words.get(value) + 1);
            }else {
                words.put(value, 1);
            }
        }
        String output = "";
        for(String word: words.keySet()){
            output = output + word + " - " + words.get(word) + "\n";
        }

        FileUtils.writeStringToFile(new File("src/main/resources/output.txt"), output, Charset.forName("UTF-8"));
    }
}
