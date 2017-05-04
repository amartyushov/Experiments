package io.mart;

import io.mart.domain.Event;
import io.mart.domain.Person;
import io.mart.util.HibernateUtil;
import org.hibernate.Session;
import org.hsqldb.Server;

import java.util.Date;
import java.util.List;

public class EventManager {

    // how to start mvn exec:java -Dexec.mainClass="io.mart.EventManager" -Dexec.args="store"
    public static void main(String[] args) {
        Server server = new Server();
        server.setDatabaseName(0, "mainDb");
        server.setDatabasePath(0, "mem:mainDb");
        server.setPort(9001); // this is the default port
        server.start();

        EventManager mgr = new EventManager();

        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date());

            List events = mgr.listEvents();
            System.out.println("Printing out results of SELECT");
            for (int i = 0; i < events.size(); i++) {
                Event theEvent = (Event) events.get(i);
                System.out.println(
                        "Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate()
                );
            }
        }
        HibernateUtil.getSessionFactory().close();
    }

    private List listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }

    private void addPersonToEvent(Long personId, Long eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);
        Event anEvent = (Event) session.load(Event.class, eventId);
        aPerson.getEvents().add(anEvent);

        session.getTransaction().commit();
    }

}
