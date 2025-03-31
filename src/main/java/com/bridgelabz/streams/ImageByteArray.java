package com.bridgelabz.streams;

import java.io.*;
public class ImageByteArray {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destinationImage = "destination.jpg";

        byte[] imageBytes = null;

        try (FileInputStream fis = new FileInputStream(sourceImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            imageBytes = baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
            return;
        }



        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(destinationImage)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image successfully copied.");
        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
        }
    }
}