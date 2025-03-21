package com.example.pro_virtual_music;

import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "demo";
        String databaseUser = "root";
        String databasePassword = "123456";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}