package com.example.java.controller;

import com.example.java.model.ClubsModel;
import com.example.java.model.PlayerModel;
import com.example.java.model.PlayerPostsModel;

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
    public static boolean InsertNewUser(String name, String username, String email, String password,String role) {
        try {
            Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_nb (name,username,email,password_hash,role) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, role);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Sikeres beillesztés");
            return rows == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Sikertelen beillesztés");
        return false;
    }

    public static boolean isInputCorrect(String username, String password) {
        try {
            Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_nb WHERE UPPER(Username) LIKE UPPER(?)");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Found matching user!");
                if (resultSet.getString("password_hash").equals(password)) {
                    System.out.println("Successfully logged in!");
                    return true;
                } else {
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


    public static List<ClubsModel> GetClubs() {
        try {
            Connect();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM klub");
            List<ClubsModel> clubs = new ArrayList<ClubsModel>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String clubName = resultSet.getString("csapatnev");
                ClubsModel newClub = new ClubsModel();
                newClub.setId(id);
                newClub.setClubName(clubName);
                clubs.add(newClub);
            }
            return clubs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<PlayerPostsModel> GetPosts() {
        try {
            Connect();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM poszt");
            List<PlayerPostsModel> playerPosts = new ArrayList<PlayerPostsModel>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String post = resultSet.getString("nev");
                PlayerPostsModel newPost = new PlayerPostsModel();
                newPost.setId(id);
                newPost.setPostName(post);
                playerPosts.add(newPost);
            }
            return playerPosts;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<PlayerModel> GetPlayers() {
        try {
            Connect();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM labdarugo");
            List<PlayerModel> players = new ArrayList<PlayerModel>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int player_number = resultSet.getInt("mezszam");
                int club_id = resultSet.getInt("klubid");
                int post_id = resultSet.getInt("posztid");
                String lastName = resultSet.getString("utonev");
                String firstName = resultSet.getString("vezeteknev");
                String szulido = resultSet.getString("szulido");
                String hungarian = resultSet.getString("magyar");
                String foreign = resultSet.getString("kulfoldi");
                String value = resultSet.getString("ertek");
                PlayerModel newPlayer = new PlayerModel();
                newPlayer.setId(id);
                newPlayer.setPlayerNumber(player_number);
                newPlayer.setClubId(club_id);
                newPlayer.setPlayerPost(post_id);
                newPlayer.setLastName(lastName);
                newPlayer.setFirstName(firstName);
                newPlayer.setBirthDate(szulido);
                newPlayer.setIsHungarian(hungarian);
                newPlayer.setIsForeign(foreign);
                newPlayer.setPlayerRate(value);
                players.add(newPlayer);
            }
            return players;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ClubsModel GetClubBasedOnId(int id)
    {
        try {
            Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM klub WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Found matching club!");
                String clubName = resultSet.getString("csapatnev");
                ClubsModel newClub = new ClubsModel();
                newClub.setId(id);
                newClub.setClubName(clubName);
                return newClub;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Did not found matching club!");
        return null;
    }

    public PlayerPostsModel GetPostBasedOnId(int id)
    {
        try {
            Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM poszt WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Found matching post!");
                String post = resultSet.getString("nev");
                PlayerPostsModel newPost = new PlayerPostsModel();
                newPost.setId(id);
                newPost.setPostName(post);
                return newPost;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Did not found matching post!");
        return null;
    }

}
