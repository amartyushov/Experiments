package io.mart.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Aleksandr Martiushov.
 * <p>
 * It is possible to see real values inside logs, instead of ?
 * <p>
 * insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)
 * <p>
 * For this you have to see TRACE logs of hibernate, log4j.logger.org.hibernate=TRACE
 * especially BasicBinder
 */
public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int studentId = 1;

            Student studentToUpdate = session.get(Student.class, studentId);
            System.out.println("Updating student " + studentToUpdate);
            studentToUpdate.setFirstName("Sasha");
            session.getTransaction().commit();



            /* bulk update*/
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
