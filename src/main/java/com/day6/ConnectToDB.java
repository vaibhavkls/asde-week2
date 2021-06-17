package com.day6;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectToDB {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/collegeapp", "postgres",
                    "admin");
            System.out.println("Database connection created successfully");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT;");
            while (rs.next()) {
                System.out.println(rs.getInt("balance"));
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
