package org.example.model;

import org.example.controller.DepartmentController;
import org.example.dto.DepartmentDto;
import org.example.entity.Department;
import org.example.utill.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

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
        DepartmentController department = session.get(DepartmentController.class, id);
        session.getTransaction().commit();
    }
    public static void updateDepartment(long id, DepartmentDto departmentDto){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Department department =  session.get(Department.class, id);
        if(department != null){
            department.setName(departmentDto.getName());
            department.setLocation(department.getLocation());
            department.setManager(department.getManager());
            department.setBudget(department.getBudget());
            session.update(department);
            session.getTransaction().commit();
        }
        else{
            System.out.println("Department not found :" +id);
        }
    }
    public static void deleteDepartment(Long id){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Department department = session.get(Department.class, id);
            if(department != null){
                session.delete(department);
                session.getTransaction().commit();
            }
            else{
                System.out.println("Department not found :" +id);
            }
        }
    }

    public static List<Department> getAllDepartment(){
        try(Session session = sessionFactory.openSession()){
            Query<Department> query = session.createQuery("from Department", Department.class);
            return query.getResultList();
        }
    }
}
