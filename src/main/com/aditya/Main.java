package com.aditya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Student s1 = new Student();
//        s1.setId(5);
//        s1.setName("Aditya");
//        s1.setAge(21);
//        s1.setEmail("aditya@gmail.com");
//        s1.setCourse("Java");

        SessionFactory factory = new Configuration()
                                .addAnnotatedClass(com.aditya.Department.class)
                                .configure().buildSessionFactory();

        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();

        Department d1 = session.find(Department.class, 2);
        List<Student> students = d1.getStudents();
        System.out.println(students);


//        Department d1 = new Department();
//        d1.setName("Computer Science");
//        session.persist(d1);
//        s1.setDepartment(d1);
//        session.persist(s1);

//        transaction.commit();
        session.close();
        factory.close();
    }
}
