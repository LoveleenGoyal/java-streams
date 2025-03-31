package com.bridgelabz.streams;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String source="src/main/java/com/bridgelabz/streams/source";
        String destination="src/main/java/com/bridgelabz/streams/destination";

        long startTime = System.nanoTime(); // start time

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] arr = new byte[1024]; //1kb
            int bytesRead;
            while ((bytesRead = bis.read(arr)) != -1) {
                bos.write(arr, 0, bytesRead);
            }

            long endTime = System.nanoTime(); // End time
            long copiedTime = endTime - startTime;

            System.out.println("File copied successfully in " + (copiedTime / 1e6) + " ms");
        }
        catch(IOException e){
            System.out.println("Error " + e.getMessage());
        }

    }
}