package io.mart.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Aleksandr Martiushov.
 */
public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            System.out.println("Creating new Student object");
            Student student0 = new Student("Alex0", "Mart", "alex@mart.com");
            Student student1 = new Student("Alex1", "Mart", "alex@mart.com");
            Student student2 = new Student("Alex2", "Mart", "alex@mart.com");

            session.beginTransaction();
            session.save(student0);
            session.save(student1);
            session.save(student2);
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
