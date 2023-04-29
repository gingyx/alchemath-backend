package com.project.repository;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private int age;
    private String gender;
    private int groupNumber;
    private String registerTime;
    private String gamificationTimes;
    private String hexad;
    private String postStudy;

    // working of app, no analysis
    private String userName;
    private int leaderboardScore = 0;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Exercise> exercises = new ArrayList<>();

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getHexad() {
        return hexad;
    }
    public void setHexad(String hexad) {
        this.hexad = hexad;
    }
    public String getPostStudy() {
        return postStudy;
    }
    public void setPostStudy(String postStudy) {
        this.postStudy = postStudy;
    }
    public String getRegisterTime() {
        return registerTime;
    }
    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
    public String getGamificationTimes() {
        return gamificationTimes;
    }
    public void setGamificationTimes(String gamificationTimes) {
        this.gamificationTimes = gamificationTimes;
    }
    public int getLeaderboardScore() {
        return leaderboardScore;
    }
    public void setLeaderboardScore(int leaderboardScore) {
        this.leaderboardScore = leaderboardScore;
    }



    // custom methods
    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

}
