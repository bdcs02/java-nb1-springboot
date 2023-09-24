package com.java_nb1.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    static Statement statement;
    static Connection connection;
    //Csatlakozás az adatbázishoz
    public static void Connect() throws SQLException {
        final String URL = "jdbc:mysql://localhost/nb-java?user=root&characterEncoding=utf8";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection(URL);
        statement = connection.createStatement();
        System.out.println("Successfully connected!");
    }

    //Ellenörzi van-e ilyen felhasználó felhasználónév alapján
    public static boolean getRegisteredUser(String username) {
        try {
            Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_nb WHERE UPPER(Username) LIKE UPPER(?)");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Found matching user!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Did not found matching user!");
        return false;
    }

    //Beilleszti az új felhasználót
    public static boolean InsertNewUser(String name,String username,String email,String password) {
        try {
            Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_nb (name,username,email,password_hash) VALUES (?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Sikeres beillesztés");
            return rows == 1;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Sikertelen beillesztés");
        return false;
    }

    public static boolean isInputCorrect(String username,String password)
    {
        try {
            Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_nb WHERE UPPER(Username) LIKE UPPER(?)");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Found matching user!");
                if( resultSet.getString("password_hash").equals(password))
                {
                    System.out.println("Successfully logged in!");
                    return true;
                }
                else
                {
                    System.out.println("Wrong password");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Did not found matching user!");
        return false;
    }
}
