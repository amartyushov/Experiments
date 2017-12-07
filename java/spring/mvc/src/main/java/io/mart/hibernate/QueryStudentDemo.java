package io.mart.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Aleksandr Martiushov.
 */
public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();


            List<Student> theStudents = session.createQuery("from Student").list();

            displayStudents(theStudents);

            /*------------------*/

            theStudents = session.createQuery("from Student s where s.firstName='Alexander'").list();

            displayStudents(theStudents);


            /*------------------*/

            theStudents = session.createQuery("from Student s where s.firstName='Alex0' AND s.lastName='Mart'").list();

            displayStudents(theStudents);

            /*------------------*/

            theStudents = session.createQuery("from Student s where s.firstName LIKE 'Alexa%'").list();

            displayStudents(theStudents);


            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student st : theStudents) {
            System.out.println(st.toString());
        }
        System.out.println("\n");
    }
}
