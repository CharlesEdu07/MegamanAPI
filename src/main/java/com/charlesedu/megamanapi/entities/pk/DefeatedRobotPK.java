package com.charlesedu.megamanapi.entities.pk;

import java.io.Serializable;

import com.charlesedu.megamanapi.entities.RobotList;
import com.charlesedu.megamanapi.entities.RobotMaster;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DefeatedRobotPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "robotList")
    private RobotList robotList;

    @ManyToOne
    @JoinColumn(name = "robotMaster")
    private RobotMaster robotMaster;

    public RobotList getRobotList() {
        return robotList;
    }

    public void setRobotList(RobotList robotList) {
        this.robotList = robotList;
    }

    public RobotMaster getRobotMaster() {
        return robotMaster;
    }

    public void setRobotMaster(RobotMaster robotMaster) {
        this.robotMaster = robotMaster;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((robotList == null) ? 0 : robotList.hashCode());
        result = prime * result + ((robotMaster == null) ? 0 : robotMaster.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefeatedRobotPK other = (DefeatedRobotPK) obj;
        if (robotList == null) {
            if (other.robotList != null)
                return false;
        } else if (!robotList.equals(other.robotList))
            return false;
        if (robotMaster == null) {
            if (other.robotMaster != null)
                return false;
        } else if (!robotMaster.equals(other.robotMaster))
            return false;
        return true;
    }
}
