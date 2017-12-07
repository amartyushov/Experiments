package io.mart.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/**
 * Created by Aleksandr Martiushov.
 */
public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try {

            System.out.println("Creating new Student object");
            Student student = new Student("Alexander", "Mart", "alex@mart.com");

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Saving student " + student);
            session.save(student);
            System.out.println("Student was saved" + student);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with id " + student.getId());
            Student student1 = session.get(Student.class, student.getId());
            session.getTransaction().commit();
            System.out.println("Student was got " + student1);

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
