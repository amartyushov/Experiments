package io.mart.hibernate.eager_vs_lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Aleksandr Martiushov.
 *
 * It is possible to see real values inside logs, instead of ?
 *
 * insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)
 *
 * For this you have to see TRACE logs of hibernate, log4j.logger.org.hibernate=TRACE
 *  especially BasicBinder
 */
public class FetchJoinDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 3;

            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                    "JOIN FETCH i.courses " +
                    "where i.id=:theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", id);

            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor " + instructor);

            session.getTransaction().commit();
            session.close();

            System.out.println("Session is closed \n");

            System.out.println("Courses" + instructor.getCourses());

        } finally {
            factory.close();
        }
    }
}
