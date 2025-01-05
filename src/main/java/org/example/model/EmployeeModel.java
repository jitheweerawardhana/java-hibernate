package org.example.model;

import org.example.controller.EmployeeController;
import org.example.utill.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeModel {

    SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

    public void addEmployee(EmployeeController employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    public void getEmployee(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeController employee = (EmployeeController) session.get(EmployeeController.class, id);
        session.getTransaction().commit();
    }

    public void updateEmployee(EmployeeController employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
    }
    public void deleteEmployee(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeController employee = (EmployeeController) session.get(EmployeeController.class, id);
        session.delete(employee);
    }

}
