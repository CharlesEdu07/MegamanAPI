package com.charlesedu.megamanapi.entities;

import java.io.Serializable;
import java.time.LocalTime;

public class Score implements Serializable {
    private UserModel user;
    private RobotMaster robotMaster;
    private Integer damageTaken;
    private LocalTime time;

    public Score() {
    }

    public Score(UserModel user, RobotMaster robotMaster, Integer damageTaken, LocalTime time) {
        this.user = user;
        this.robotMaster = robotMaster;
        this.damageTaken = damageTaken;
        this.time = time;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public RobotMaster getRobotMaster() {
        return robotMaster;
    }

    public void setRobotMaster(RobotMaster robotMaster) {
        this.robotMaster = robotMaster;
    }

    public Integer getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(Integer damageTaken) {
        this.damageTaken = damageTaken;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }  
}
