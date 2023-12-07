package org.saraansh.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Day7 {

    public static void main(String[] args){
        try {
            //String fileName = "src/main/java/org/saraansh/day7/test.txt";
            String fileName = "src/main/java/org/saraansh/day7/input.txt";
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String data = fileReader.next();
                System.out.println(data);
            }

            fileReader.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
