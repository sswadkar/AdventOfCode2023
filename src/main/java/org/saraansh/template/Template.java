package org.saraansh.template;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Template {

    public static void main(String[] args){
        try {
            //String fileName = "src/main/java/org/saraansh/template/test.txt";
            String fileName = "src/main/java/org/saraansh/template/input.txt";
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
