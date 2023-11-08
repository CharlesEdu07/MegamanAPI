package com.charlesedu.megamanapi.entities;

import com.charlesedu.megamanapi.entities.pk.DefeatedRobotPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class DefeatedRobot {
    @EmbeddedId
    private DefeatedRobotPK id = new DefeatedRobotPK();

    private Integer damageTaken;

    public DefeatedRobot() {
    }

    public DefeatedRobot(ListRobot listRobot, RobotMaster robotMaster, Integer damageTaken) {
        id.setListRobot(listRobot);
        id.setRobotMaster(robotMaster);
        this.damageTaken = damageTaken;
    }

    public ListRobot getListRobot() {
        return id.getListRobot();
    }

    public void setListRobot(ListRobot listRobot) {
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
}
