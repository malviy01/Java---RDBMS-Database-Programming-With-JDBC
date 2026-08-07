package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {
    public static void main(String[] args) {

        try {
            // Load Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/assignment_7",
                "root",
                ""
            );

            // Create Statement (IMPORTANT: scrollable ResultSet)
            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            // Execute SELECT query
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            // ===== next() =====
            System.out.println("Using next():");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("fname") + " " +
                    rs.getString("lname") + " " +
                    rs.getString("email")
                );
            }

            // ===== previous() =====
            System.out.println("\nUsing previous():");
            while (rs.previous()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("fname") + " " +
                    rs.getString("lname") + " " +
                    rs.getString("email")
                );
            }

            // ===== first() =====
            System.out.println("\nFirst Record:");
            if (rs.first()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("fname") + " " +
                    rs.getString("lname") + " " +
                    rs.getString("email")
                );
            }

            // ===== last() =====
            System.out.println("\nLast Record:");
            if (rs.last()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("fname") + " " +
                    rs.getString("lname") + " " +
                    rs.getString("email")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}