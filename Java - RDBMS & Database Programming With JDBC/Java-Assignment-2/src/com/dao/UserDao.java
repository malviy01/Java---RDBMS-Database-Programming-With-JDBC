package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.model.UserModel;
import com.util.DBUtil;

public class UserDao {

    Connection cn = null;

    // 🔹 INSERT using Statement
    public void insertUsingStatement() {
        try {
            cn = new DBUtil().getConnectionData();
            Statement st = cn.createStatement();

            st.executeUpdate("INSERT INTO users(fname,lname,email) VALUES('John','Doe','john@gmail.com')");
            System.out.println("Inserted using Statement");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE using Statement
    public void updateUsingStatement() {
        try {
            cn = new DBUtil().getConnectionData();
            Statement st = cn.createStatement();

            st.executeUpdate("UPDATE users SET fname='Johnny' WHERE email='john@gmail.com'");
            System.out.println("Updated using Statement");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE using Statement
    public void deleteUsingStatement() {
        try {
            cn = new DBUtil().getConnectionData();
            Statement st = cn.createStatement();

            st.executeUpdate("DELETE FROM users WHERE email='john@gmail.com'");
            System.out.println("Deleted using Statement");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 SELECT using Statement
    public void selectUsingStatement() {
        try {
            cn = new DBUtil().getConnectionData();
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("fname") + " " +
                    rs.getString("lname") + " " +
                    rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================== PREPARED STATEMENT ==================

    // 🔹 INSERT
    public void insertUsingPrepared() {
        try {
            cn = new DBUtil().getConnectionData();

            PreparedStatement ps = cn.prepareStatement(
                "INSERT INTO users(fname,lname,email) VALUES(?,?,?)"
            );

            ps.setString(1, "Rudray");
            ps.setString(2, "Pandya");
            ps.setString(3, "rudray@gmail.com");

            ps.executeUpdate();
            System.out.println("Inserted using PreparedStatement");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE
    public void updateUsingPrepared() {
        try {
            cn = new DBUtil().getConnectionData();

            PreparedStatement ps = cn.prepareStatement(
                "UPDATE users SET fname=? WHERE email=?"
            );

            ps.setString(1, "Rocky");
            ps.setString(2, "rocky@gmail.com");

            ps.executeUpdate();
            System.out.println("Updated using PreparedStatement");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE
    public void deleteUsingPrepared() {
        try {
            cn = new DBUtil().getConnectionData();

            PreparedStatement ps = cn.prepareStatement(
                "DELETE FROM users WHERE email=?"
            );

            ps.setString(1, "rudray@gmail.com");

            ps.executeUpdate();
            System.out.println("Deleted using PreparedStatement");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 SELECT
    public void selectUsingPrepared() {
        try {
            cn = new DBUtil().getConnectionData();

            PreparedStatement ps = cn.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("fname") + " " +
                    rs.getString("lname") + " " +
                    rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}