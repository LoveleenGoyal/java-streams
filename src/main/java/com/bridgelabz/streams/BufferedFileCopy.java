package com.bridgelabz.streams;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String source = "src/main/java/com/bridgelabz/streams/source";
        String destinationBuffered = "src/main/java/com/bridgelabz/streams/destination_buffered";
        String destinationUnbuffered = "src/main/java/com/bridgelabz/streams/destination_unbuffered";

        // Buffered Streams
        long startTimeBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationBuffered))) {
            byte[] arr = new byte[1024]; // 1KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(arr)) != -1) {
                bos.write(arr, 0, bytesRead);
            }
            long endTimeBuffered = System.nanoTime();
            System.out.println("Buffered copy completed in " + (endTimeBuffered - startTimeBuffered) / 1e6 + " ms");
        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
        }

        // Unbuffered Streams
        long startTimeUnbuffered = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destinationUnbuffered)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            long endTimeUnbuffered = System.nanoTime();
            System.out.println("Unbuffered copy completed in " + (endTimeUnbuffered - startTimeUnbuffered) / 1e6 + " ms");
        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
        }
    }
}
