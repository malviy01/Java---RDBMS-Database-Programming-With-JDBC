// TestConnection.java
package com.main;

import java.sql.Connection;

import com.util.DBUtil;

public class TestConnection {
    public static void main(String[] args) {
        DBUtil db = new DBUtil();
        Connection cn = db.getConnectionData();

        if (cn != null) {
            System.out.println("Database Connected!");
        } else {
            System.out.println("Connection Failed!");
        }
    }
}