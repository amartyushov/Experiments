package io.mart.hibernate.one_to_one_bi_direct;

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
public class GetInstructorDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //int theId = 2; // check what is present in db now

            int theId = 23; // lets break

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("instructorDetail " + instructorDetail);

            System.out.println("Associated instructor " + instructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close(); // no more leaks (ERROR: Connection leak detected: there are 1 unclosed connections upon shutting down pool jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false)

            factory.close();
        }
    }
}
