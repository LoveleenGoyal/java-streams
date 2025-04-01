package com.bridgelabz.streams;

import java.io.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/bridgelabz/streams/source";

        // Read file line by line efficiently
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("streams")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}