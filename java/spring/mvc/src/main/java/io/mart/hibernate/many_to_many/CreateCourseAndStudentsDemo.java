package io.mart.hibernate.many_to_many;

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
public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Pacman");

            System.out.println("Saving the course " + course);
            session.save(course);

            System.out.println("Course is saved: " + course);


            Student student1 = new Student("Alex", "Mart", "alex@mart.com");
            Student student2 = new Student("Olia", "Mart", "alex@mart.com");
            Student student3 = new Student("Mama", "Mart", "alex@mart.com");

            course.add(student1);
            course.add(student2);
            course.add(student3);

            System.out.println("Saving students\n");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            System.out.println("\nSaved students " + course.getStudents());

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
