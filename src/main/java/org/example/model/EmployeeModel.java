package org.example.model;

import org.example.controller.Employee;
import org.example.utill.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeModel {

    SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

    public void addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    public void getEmployee(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        session.getTransaction().commit();
    }

    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
    }
    public void deleteEmployee(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        session.delete(employee);
    }

}
