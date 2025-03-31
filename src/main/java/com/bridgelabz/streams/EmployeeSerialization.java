package com.bridgelabz.streams;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class EmployeeSerialization {
    private static final String SRC = "employees.ser";

    public static void serializeEmployees(List<Employee> emp) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SRC))) {
            oos.writeObject(emp);
            System.out.println("Employees successfully serialized.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SRC))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees successfully deserialized.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Loveleen", "HR", 70000));
        employeeList.add(new Employee(102, "Yagyata", "IT", 60000));
        employeeList.add(new Employee(103, "Ria", "Finance", 55000));

        // Serialize the employee list
        serializeEmployees(employeeList);

        // Deserialize and display employees
        List<Employee> deserializedEmployees = deserializeEmployees();
        if (deserializedEmployees != null) {
            for (Employee emp : deserializedEmployees) {
                emp.display();
            }
        }
    }
}

/*Employees successfully serialized.
Employees successfully deserialized.
ID: 101, Name: Loveleen, Department: HR, Salary: 70000.0
ID: 102, Name: Yagyata, Department: IT, Salary: 60000.0
ID: 103, Name: Ria, Department: Finance, Salary: 55000.0
*/