package com.example.java.model;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;


@Entity
@Table(name="user_nb")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "username")
    private String Username;

    @Column(name = "password_hash")
    private String Password;

    @Column(name = "email")
    private String Email;

    @Column(name = "role")
    private String Role;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
