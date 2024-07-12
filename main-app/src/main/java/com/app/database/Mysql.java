package com.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Mysql {
    private static Mysql _instance;
    private Connection _connection;

    public static Mysql getInstance() {
        if (_instance == null) {
            _instance = new Mysql();
        }
        return _instance;
    }

    public ArrayList<ArrayList<String>> getLion() {
        String query = "select * from Lion";
        ArrayList<ArrayList<String>> datas = new ArrayList<>();
        try (Statement stmt = _connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ArrayList<String>data = new ArrayList<>();
                String lionsname = rs.getString("NAME");
                int id = rs.getInt("ID");
                data.add(Integer.toString(id));
                data.add(lionsname);
                datas.add(data);
            }
        } catch (SQLException e) {
            System.out.println("Exception is " + e.getMessage());
        }
        return datas;
    }

    private void Connection() {
        try {
            String url = "jdbc:mysql://localhost:3306/InfoUser";
            String username = "root";
            String password = "my-secret-pw";
            _connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
    }
    
    public Mysql() {
        Connection();
    }
}
