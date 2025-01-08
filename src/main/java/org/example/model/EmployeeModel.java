package org.example.model;

import org.example.controller.EmployeeController;
import org.example.entity.Department;
import org.example.utill.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeModel {

    SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

    public void saveEmployee(EmployeeController employee) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Department department = session.createQuery("from Department where  name = :name",Department.class);

        }
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
