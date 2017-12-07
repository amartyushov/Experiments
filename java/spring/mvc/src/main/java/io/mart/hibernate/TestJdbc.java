package io.mart.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Aleksandr Martiushov.
 */
public class TestJdbc {
    public static void main(String[] args) {
        try {
            //String jdbcUrl = "hibernate:mysql://localhost:3306/hb_student_tracker?useSSL=false";
            String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
            String user = "root";
            String pass = "pass";

            System.out.println("Connecting to database");
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
