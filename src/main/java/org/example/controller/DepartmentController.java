package org.example.controller;

import org.example.dto.DepartmentDto;
import org.example.entity.Department;
import org.example.model.DepartmentModel;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {

    private String name;
    private String location;
    private String manager;
    private double budget;

    public static void addDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        String name = sc.nextLine();
        System.out.print("Enter department's location: ");
        String location = sc.nextLine();
        System.out.print("Enter department's manager: ");
        String manager = sc.nextLine();
        System.out.println("Enter department budget: ");
        double budget = sc.nextDouble();

        boolean i = DepartmentModel.saveDepartment(new DepartmentDto(name,location,manager,budget));

        if (i) {
            System.out.println("Department has been saved");
        }
        else {
            System.out.println("Department has not been saved");
        }
    }

    public static void getAllDepartments() {
        List<Department> departments = DepartmentModel.getAllDepartment();
        departments.forEach(System.out::println);
    }

    public static void updateDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department's ID: ");
        Long id = sc.nextLong();
        sc.nextLine();

        System.out.println("Enter department's name: ");
        String name = sc.nextLine();

        System.out.println("Enter department's location: ");
        String location = sc.nextLine();

        System.out.println("Enter department's manager name ");
        String manager = sc.nextLine();

        System.out.println("Enter department budget: ");
        double budget = sc.nextDouble();

        DepartmentDto updatedData = new DepartmentDto(name,location,manager,budget);
        DepartmentModel.updateDepartment(id, updatedData);
    }

    public static void deleteDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department's ID: ");
        Long id = sc.nextLong();
        sc.nextLine();
        DepartmentModel.deleteDepartment(id);
    }
}
