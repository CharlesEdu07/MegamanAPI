package com.charlesedu.megamanapi.entities.pk;

import com.charlesedu.megamanapi.entities.ListRobot;
import com.charlesedu.megamanapi.entities.RobotMaster;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DefeatedRobotPK {
    @ManyToOne
    @JoinColumn(name = "list_id")
    private ListRobot listRobot;

    @ManyToOne
    @JoinColumn(name = "robot_id")
    private RobotMaster robotMaster;

    public ListRobot getListRobot() {
        return listRobot;
    }

    public void setListRobot(ListRobot listRobot) {
        this.listRobot = listRobot;
    }

    public RobotMaster getRobotMaster() {
        return robotMaster;
    }

    public void setRobotMaster(RobotMaster robotMaster) {
        this.robotMaster = robotMaster;
    }
}
