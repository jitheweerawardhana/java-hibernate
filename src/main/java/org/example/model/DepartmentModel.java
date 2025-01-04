package org.example.model;

import org.example.controller.Department;
import org.example.dto.DepartmentDto;
import org.example.utill.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DepartmentModel {

    static SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

    public static boolean saveDepartment(DepartmentDto departmentDto){
        boolean flag = false;
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(departmentDto);
            session.getTransaction().commit();
            flag = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return flag;
    }
    public void getDepartment(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Department department = session.get(Department.class, id);
        session.getTransaction().commit();
    }
    public void updateDepartment(Department department){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(department);
        session.getTransaction().commit();
    }
    public void deleteDepartment(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Department department = session.get(Department.class, id);
        session.delete(department);
        session.getTransaction().commit();
    }
}
