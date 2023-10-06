package com.example.java.controller;

import com.example.java.model.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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

    public static List<UserModel> GetUsers() {
        try {
            Connect();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user_nb");
            List<UserModel> users = new ArrayList<UserModel>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                String Username = resultSet.getString("username");
                String pw = resultSet.getString("password_hash");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                UserModel newUser = new UserModel();
                newUser.setId(id);
                newUser.setName(Name);
                newUser.setUsername(Username);
                newUser.setPassword(pw);
                newUser.setEmail(email);
                newUser.setRole(role);
                users.add(newUser);
            }
            return users;
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

    public static List<ContactFormModel> GetContacts() {
        try {
            Connect();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contact ORDER BY id DESC ");
            List<ContactFormModel> contactFormModels = new ArrayList<ContactFormModel>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String message = resultSet.getString("message");
                Date created_at = resultSet.getDate("created_at");
                ContactFormModel contact = new ContactFormModel();
                contact.setId(id);
                contact.setName(name);
                contact.setMessage(message);
                contact.setCreated_at(created_at);
                contactFormModels.add(contact);
            }
            return contactFormModels;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
