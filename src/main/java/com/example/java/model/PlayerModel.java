package com.example.java.model;

import jakarta.persistence.*;

@Entity
@Table(name = "labdarugo")
public class PlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "mezszam")
    private int playerNumber;
    @Column(name = "klubid")
    private int clubId;
    @Column(name = "posztid")
    private int playerPost;

    @Column(name = "utonev")
    private String firstName;

    @Column(name = "vezeteknev")
    private String lastName;

    @Column(name = "szulido")
    private String birthDate;

    @Column(name = "magyar")
    private String isHungarian;

    @Column(name = "kulfoldi")
    private String isForeign;

    @Column(name = "ertek")
    private String playerRate;

    @ManyToOne
    @JoinColumn(name = "klubid",  referencedColumnName = "Id", insertable=false, updatable=false)
    private ClubsModel club;

    @ManyToOne
    @JoinColumn(name = "posztid", referencedColumnName = "Id", insertable=false, updatable=false)
    private PlayerPostsModel post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClubsModel getClub() {
        return club;
    }

    public void setClub(ClubsModel club) {
        this.club = club;
    }

    public PlayerPostsModel getPost() {
        return post;
    }

    public void setPost(PlayerPostsModel post) {
        this.post = post;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public int getPlayerPost() {
        return playerPost;
    }

    public void setPlayerPost(int playerPost) {
        this.playerPost = playerPost;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIsHungarian() {
        return isHungarian;
    }

    public void setIsHungarian(String isHungarian) {
        this.isHungarian = isHungarian;
    }

    public String getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(String isForeign) {
        this.isForeign = isForeign;
    }

    public String getPlayerRate() {
        return playerRate;
    }

    public void setPlayerRate(String playerRate) {
        this.playerRate = playerRate;
    }
}



