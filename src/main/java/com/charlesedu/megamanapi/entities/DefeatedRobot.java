package com.charlesedu.megamanapi.entities;

import java.time.LocalTime;

import com.charlesedu.megamanapi.entities.pk.DefeatedRobotPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class DefeatedRobot {
    @EmbeddedId
    private DefeatedRobotPK id = new DefeatedRobotPK();

    private Integer damageTaken;
    private LocalTime time;

    public DefeatedRobot(RobotMaster robotMaster, RobotList robotList, Integer damageTaken, LocalTime time) {
    }

    public DefeatedRobot(RobotList listRobot, RobotMaster robotMaster, Integer damageTaken, LocalTime time) {
        id.setListRobot(listRobot);
        id.setRobotMaster(robotMaster);
        this.damageTaken = damageTaken;
        this.time = time;
    }

    @JsonIgnore
    public RobotList getListRobot() {
        return id.getListRobot();
    }

    public void setListRobot(RobotList listRobot) {
        id.setListRobot(listRobot);
    }

    public RobotMaster getRobotMaster() {
        return id.getRobotMaster();
    }

    public void setRobotMaster(RobotMaster robotMaster) {
        id.setRobotMaster(robotMaster);
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
