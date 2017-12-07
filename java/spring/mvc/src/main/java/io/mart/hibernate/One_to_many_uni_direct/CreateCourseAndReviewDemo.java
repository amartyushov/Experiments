package io.mart.hibernate.One_to_many_uni_direct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
public class CreateCourseAndReviewDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Pacman");
            course.add(new Review("Cool course"));
            course.add(new Review("Bad course"));
            course.add(new Review("Average course"));

            System.out.println("Saving the course " + course);
            System.out.println(course.getReviews());
            session.save(course);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
