package com.joshua;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentScores2 {
    public static void main(String[] args){
        String gradesFile = "lab5/src/main/resources/grades.txt";
        String averageFile = "lab5/src/main/resources/averages.txt";

        try {
            openFile(gradesFile);
            String fileContent = readFile(gradesFile);
            String[] outputLines = processFile(fileContent);
            writeFile(averageFile, outputLines);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + averageFile);
        }    
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
    public static String[] processFile(String fileContent) {
        String[] lines = fileContent.split(System.lineSeparator());
        String[] processedLines = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split(",");
            String name = parts[0];
            try {
                int score1 = Integer.parseInt(parts[1].trim());
                int score2 = Integer.parseInt(parts[2].trim());
                int score3 = Integer.parseInt(parts[3].trim());
                if (score1 < 0 || score2 < 0 || score3 < 0) {
                    processedLines[i] = name + ",Error: Negative score encountered.";
                    continue;
                }
                if (score1 > 100 || score2 > 100 || score3 > 100) {
                    processedLines[i] = name + ",Error: Score exceeds maximum value of 100.";
                    continue;
                }
                double average = (score1 + score2 + score3) / 3.0;
                String formattedAverage = String.format("%.2f", average); 
                processedLines[i] = name + "," + formattedAverage;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                processedLines[i] = name + ",Error: Invalid number format or missing scores.";
            }
        }
        return processedLines;
    }
    public static void writeFile(String filePath, String[] lines) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            for (String line : lines) {
                if (line != null && !line.trim().isEmpty()) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + filePath);
                }
            }
        }
    }
}