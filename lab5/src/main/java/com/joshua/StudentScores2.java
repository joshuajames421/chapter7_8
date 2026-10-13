package com.joshua;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentScores2 {
    public static void main(String[] args){
        String gradesFile = "lab5/src/main/resources/grades.txt";
        String averageFile = "lab5/src/main/resources/averages.txt";
    }            

    public static File openFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            throw new FileNotFoundException("Cannot open file: " + filePath);
        }
        return file;
    }
    public static String readFile(String filePath) throws FileNotFoundException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Error reading file: " + filePath);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + filePath);
                }
            }
        }
        return builder.toString();
    }
    public static void processFile(String filePath) {
        try {
            File myObj = openFile(filePath);
            String fileContent = readFile(filePath);
            System.out.println("File content:\n" + fileContent);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}