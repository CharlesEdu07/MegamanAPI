package com.charlesedu.megamanapi.entities;

import java.io.Serializable;
import java.time.LocalTime;

import com.charlesedu.megamanapi.entities.pk.DefeatedRobotPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_defeated_robot")
public class DefeatedRobot implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DefeatedRobotPK id = new DefeatedRobotPK();

    private Integer damageTaken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime time;

    public DefeatedRobot() {
    }

    public DefeatedRobot(RobotList robotList, RobotMaster robotMaster, Integer damageTaken, LocalTime time) {
        id.setRobotList(robotList);
        id.setRobotMaster(robotMaster);
        this.damageTaken = damageTaken;
        this.time = time;
    }

    @JsonIgnore
    public RobotList getRobotList() {
        return id.getRobotList();
    }

    public void setRobotList(RobotList robotList) {
        id.setRobotList(robotList);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        DefeatedRobot other = (DefeatedRobot) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DefeatedRobot [id=" + id + ", damageTaken=" + damageTaken + ", time=" + time + "]";
    }
}
