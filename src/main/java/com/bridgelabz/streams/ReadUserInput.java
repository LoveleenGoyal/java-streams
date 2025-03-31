package com.bridgelabz.streams;

import java.io.*;

public class ReadUserInput {
    public static void main(String[] args) {
        String destination = "src/main/java/com/bridgelabz/streams/destination";
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                FileWriter fw = new FileWriter(destination)
        ) {
            System.out.println("Enter name: ");
            String name = br.readLine();

            System.out.println("Enter age: ");
            String age = br.readLine();

            System.out.println("Enter language: ");
            String lang = br.readLine();

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + lang + "\n");

            System.out.println("User data has been saved to " + destination);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
Enter name:
Loveleen
Enter age:
21
Enter language:
Punjabi
User data has been saved to src/main/java/com/bridgelabz/streams/destination

* */