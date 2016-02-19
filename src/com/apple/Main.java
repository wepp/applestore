package com.apple;

import java.sql.*;

public class Main {
    static Connection conn;
    public static void main(String[] args) {

        System.out.println("Hello World!");
        final String mysqlProtocol = "jdbc:mysql://localhost:3306/"; //our mysql server
        final String dbName="applestore"; //name of our db
        final String jdbcURL = mysqlProtocol+dbName;
        final String mysqlDriver = "com.mysql.jdbc.Driver"; //need to download driver and put it in libs
        System.setProperty("jdbc.drivers", mysqlDriver);
        try {
            conn = DriverManager.getConnection(jdbcURL, "root","root"); //login and password of our db
        } catch (SQLException e) {
            System.err.println("Connection error");
        }

        String query="SELECT * from user";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.prepareStatement(query);
            rs=statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + rs.getString("login") + rs.getString("password") + rs.getInt("role"));
            }
        } catch (SQLException e) {
            System.err.println("Select error");
        }
    }
}
