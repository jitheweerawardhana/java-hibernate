package org.example.model;

import org.example.controller.EmployeeController;
import org.example.dto.EmployeeDto;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.utill.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeModel {

    static SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

    public void saveEmployee(EmployeeDto employeeDto) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Department department = session.createQuery("from Department where  name = :name",Department.class)
                    .setParameter("name",employeeDto.getName())
                    .uniqueResult();
        }
    }

    public List<Employee> getAllEmployees() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Employee",Employee.class).list();
        }
    }

    public static void updateEmployee(Long id, EmployeeDto employeeDto) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();

            Employee employee = session.get(Employee.class,id);
            if(employee==null){
                System.out.println("Employee not found");
                session.getTransaction().rollback();
                return;
            }
        }
    }
    public void deleteEmployee(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeController employee = (EmployeeController) session.get(EmployeeController.class, id);
        session.delete(employee);
    }

}
