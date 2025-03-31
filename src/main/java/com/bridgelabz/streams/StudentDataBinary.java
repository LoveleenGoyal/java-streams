package com.bridgelabz.streams;

import java.io.*;

public class StudentDataBinary {
    private static final String SRC = "students.dat";

    public static void main(String[] args) {
        // Writing student details to a binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(SRC))) {
            dos.writeInt(101);
            dos.writeUTF("Loveleen");
            dos.writeDouble(9.4);

            dos.writeInt(102);
            dos.writeUTF("Yagyata");
            dos.writeDouble(9.3);

            dos.writeInt(103);
            dos.writeUTF("Love");
            dos.writeDouble(9.9);

            System.out.println("Student details successfully written to " + SRC);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // Reading student details from a binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(SRC))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
