package com.joshua;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class StudentScores {
    public static void main(String[] args){
        File myObj = new File("lab5/src/main/resources/grades.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                // I need to put the averages and the output here. 
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                String name = parts[0];
                int score1 = Integer.parseInt(parts[1]);
                int score2 = Integer.parseInt(parts[2]);
                int score3 = Integer.parseInt(parts[3]);
                double average = (score1 + score2 + score3) / 3.0;
                System.out.println("Name: " + name + ", Average Score: " + average);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Catch FileNotFoundException:" + "File not found.");
        } catch (NumberFormatException e) {
            System.out.println("Catch NumberFormatException:" + "Invalid number format.");
        } catch (Exception e) {
            System.out.println("Catch Exception:" + "An error occurred.");
        }
    }
}


        try {
            
            try (BufferedReader myReader = new BufferedReader(new java.io.FileReader(myObj))) {
                String data;
                while ((data = myReader.readLine()) != null) {
                    String[] parts = data.split(",");
                    String name = parts[0];
                    int score1 = Integer.parseInt(parts[1].trim());
                    int score2 = Integer.parseInt(parts[2].trim());
                    int score3 = Integer.parseInt(parts[3].trim());
                    double average = (score1 + score2 + score3) / 3.0;
                    System.out.println("Name: " + name + ", Average Score: " + average);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Catch NumberFormatException: Invalid number format.");
        } catch (Exception e) {
            System.out.println("Catch Exception: An error occurred.");
        }