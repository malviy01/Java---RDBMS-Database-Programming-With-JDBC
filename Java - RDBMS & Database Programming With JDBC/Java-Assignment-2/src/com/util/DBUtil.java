// DBUtil.java
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    Connection cn = null;

    public Connection getConnectionData() {
        try {
            // 1. Load JDBC Driver (Updated)
            Class.forName("com.mysql.jdbc.Driver");

            // 2. Establish Connection
            cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/assignment_7",
                "root",
                "" // put your MySQL password if you have
            );

            System.out.println("Connection Established Successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cn;
    }
}