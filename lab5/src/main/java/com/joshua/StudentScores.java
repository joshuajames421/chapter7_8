package com.joshua;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class StudentScores {
    public static void main(String[] args){
        File myObj = new File("lab5/src/main/resources/grades.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
