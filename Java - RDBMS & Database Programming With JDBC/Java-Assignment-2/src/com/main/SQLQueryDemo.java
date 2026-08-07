// SQLQueryDemo.java
package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBUtil;

public class SQLQueryDemo {
    public static void main(String[] args) {

        try {
            Connection cn = new DBUtil().getConnectionData();

            // INSERT
            PreparedStatement psInsert = cn.prepareStatement(
                "INSERT INTO users(fname,lname,email) VALUES(?,?,?)"
            );
            psInsert.setString(1, "Rudray");
            psInsert.setString(2, "Pandya");
            psInsert.setString(3, "rudray@gmail.com");
            psInsert.executeUpdate();
            System.out.println("Record Inserted");

            // UPDATE
            PreparedStatement psUpdate = cn.prepareStatement(
                "UPDATE users SET fname=? WHERE email=?"
            );
            psUpdate.setString(1, "Rudray Pandya");
            psUpdate.setString(2, "rudray@gmail.com");
            psUpdate.executeUpdate();
            System.out.println("Record Updated");

            // SELECT
            PreparedStatement psSelect = cn.prepareStatement(
                "SELECT * FROM users WHERE fname=?"
            );
            psSelect.setString(1, "Rudray Pandya");
            ResultSet rs = psSelect.executeQuery();

            System.out.println("Selected Records:");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("fname") + " " +
                    rs.getString("lname") + " " +
                    rs.getString("email")
                );
            }

            // DELETE
            PreparedStatement psDelete = cn.prepareStatement(
                "DELETE FROM users WHERE email=?"
            );
            psDelete.setString(1, "rudray@gmail.com");
            psDelete.executeUpdate();
            System.out.println("Record Deleted");

            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}