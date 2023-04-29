package com.project.repository;

import jakarta.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private long exerciseId;
    private String statement;
    private String startTime;
    private String elapsedTime;
    private int attemptCount;
    private int posOnScreen; // top left, top right, bottom left, bottom right
    private int rewardType;
    private String globalElos;
    private String userElos;
    private int difficultyOrd;

    public long getExerciseId() {
        return exerciseId;
    }
    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getElapsedTime() {return elapsedTime;}
    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
    public String getStatement() {
        return statement;
    }
    public void setStatement(String statement) {
        this.statement = statement;
    }
    public int getAttemptCount() {
        return attemptCount;
    }
    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }
    public int getPosOnScreen() {
        return posOnScreen;
    }
    public void setPosOnScreen(int posOnScreen) {this.posOnScreen = posOnScreen;}
    public int getRewardType() {
        return rewardType;
    }
    public void setRewardType(int rewardType) {
        this.rewardType = rewardType;
    }
    public String getGlobalElos() {
        return globalElos;
    }
    public void setGlobalElos(String exerciseElos) {
        this.globalElos = exerciseElos;
    }
    public String getUserElos() {
        return userElos;
    }
    public void setUserElos(String userElos) {
        this.userElos = userElos;
    }
    public int getDifficultyOrd() {
        return difficultyOrd;
    }
    public void setDifficultyOrd(int difficultyOrd) {
        this.difficultyOrd = difficultyOrd;
    }

}
