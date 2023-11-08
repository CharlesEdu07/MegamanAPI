package com.charlesedu.megamanapi.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "tb_robot_master")
public class RobotMaster {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String series;
    private String robotNumber;
    private String name;
    private String weapon;
    private String avatar;
    private String sprite;
    private String weakness;

    public RobotMaster() {
    }

    public RobotMaster(UUID id, String series, String robotNumber, String name, String weapon, String avatar,
            String sprite, String weakness) {
        this.id = id;
        this.series = series;
        this.robotNumber = robotNumber;
        this.name = name;
        this.weapon = weapon;
        this.avatar = avatar;
        this.sprite = sprite;
        this.weakness = weakness;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRobotNumber() {
        return robotNumber;
    }

    public void setRobotNumber(String robotNumber) {
        this.robotNumber = robotNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
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
        RobotMaster other = (RobotMaster) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
