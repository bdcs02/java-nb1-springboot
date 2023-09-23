package com.java_nb1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "labdarugo")
public class Player {
    @Id
    private int Id;
    @Column(name = "mezszam")
    private int PlayerNumber;
    @Column(name = "klubid")
    private int ClubId;
    @Column(name = "posztid")
    private int PlayerPost;

    @Column(name = "utonev")
    private String FirstName;

    @Column(name = "vezeteknev")
    private String LastName;

    @Column(name = "szulido")
    private String BirthDate;

    @Column(name = "magyar")
    private String IsHungarian;

    @Column(name = "kulfoldi")
    private String IsForeign;

    @Column(name = "ertek")
    private String PlayerRate;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPlayerNumber() {
        return PlayerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        PlayerNumber = playerNumber;
    }

    public int getClubId() {
        return ClubId;
    }

    public void setClubId(int clubId) {
        ClubId = clubId;
    }

    public int getPlayerPost() {
        return PlayerPost;
    }

    public void setPlayerPost(int playerPost) {
        PlayerPost = playerPost;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getIsHungarian() {
        return IsHungarian;
    }

    public void setIsHungarian(String isHungarian) {
        IsHungarian = isHungarian;
    }

    public String getIsForeign() {
        return IsForeign;
    }

    public void setIsForeign(String isForeign) {
        IsForeign = isForeign;
    }

    public String getPlayerRate() {
        return PlayerRate;
    }

    public void setPlayerRate(String playerRate) {
        PlayerRate = playerRate;
    }
}



