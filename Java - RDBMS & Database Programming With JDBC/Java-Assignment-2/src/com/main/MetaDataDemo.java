package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class MetaDataDemo {
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

            // Create Statement
            Statement st = con.createStatement();

            // Execute SELECT query
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            // Get ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            // Get column count
            int columnCount = rsmd.getColumnCount();
            System.out.println("Total Columns: " + columnCount);

            // Loop through columns
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("Name: " + rsmd.getColumnName(i));
                System.out.println("Type: " + rsmd.getColumnTypeName(i));
                System.out.println("----------------------");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}