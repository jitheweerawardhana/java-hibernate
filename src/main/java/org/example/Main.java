package org.example;

import org.example.controller.DepartmentController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("1. Department Operations");
            System.out.println("2. Employee Operations");
            System.out.println("3. Quit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> departmentMenu();
                case 2 -> empolyeeMenu();
                case 3 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }

        }
    }

    public static void departmentMenu(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("____Department Operations____");
            System.out.println("1. Create Department");
            System.out.println("2. Get All Departments");
            System.out.println("3. Update Department");
            System.out.println("4. Delete Department");
            System.out.println("0. Back to Mane Menu");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1-> DepartmentController.addDepartment();
                case 2-> DepartmentController.getAllDepartments();
                case 3 -> DepartmentController.updateDepartment();
                case 4 -> DepartmentController.deleteDepartment();
                case 0 -> {
                    System.out.println("Back to Mane Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
    public static void empolyeeMenu(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("____Employee Operations____");
            System.out.println("1. Create Employee");
            System.out.println("2. Get All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Back to Mane Menu");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

            }
        }
    }
}