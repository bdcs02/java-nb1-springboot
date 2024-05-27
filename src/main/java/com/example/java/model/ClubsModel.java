package com.example.java.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "klub")
public class ClubsModel {
    @Id
    private int Id;
    @Column(name = "csapatnev")
    private String ClubName;

    @OneToMany(mappedBy = "club")
    private List<PlayerModel> player;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getClubName() {
        return ClubName;
    }

    public void setClubName(String clubName) {
        ClubName = clubName;
    }

}
