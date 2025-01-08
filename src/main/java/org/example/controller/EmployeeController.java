package org.example.controller;

import org.example.dto.EmployeeDto;
import org.example.entity.Employee;
import org.example.model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);

    public  static void createEmloyee(){
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.println("Enter employee email: ");
        String email = scanner.nextLine();

        System.out.println("Enter employee salary: ");
        Double salary = scanner.nextDouble();

        System.out.println("Enter employee Department Name: ");
        String departmentName = scanner.nextLine();

//        EmployeeDto employeeDto = new EmployeeDto(name,email,salary,departmentName);
//        Employee.add(employeeDTO);

        System.out.println("Employee created");
    }
}
