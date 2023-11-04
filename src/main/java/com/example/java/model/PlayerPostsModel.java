package com.example.java.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "poszt")
public class PlayerPostsModel {

    @Id
    private int Id;
    @Column(name = "nev")
    private String PostName;

    @OneToMany(mappedBy = "post")
    private List<PlayerModel> player;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPostName() {
        return PostName;
    }

    public void setPostName(String postName) {
        PostName = postName;
    }
}

