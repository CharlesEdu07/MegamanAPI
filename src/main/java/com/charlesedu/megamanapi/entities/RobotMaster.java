package com.charlesedu.megamanapi.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_robot_master")
public class RobotMaster implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String series;
    private String robot_number;
    private String name;
    private String weapon;
    private String avatar;
    private String sprite;
    private String weakness;

    public RobotMaster() {
    }

    public RobotMaster(Long id, String series, String robot_number, String name, String weapon, String avatar,
            String sprite, String weakness) {
        this.id = id;
        this.series = series;
        this.robot_number = robot_number;
        this.name = name;
        this.weapon = weapon;
        this.avatar = avatar;
        this.sprite = sprite;
        this.weakness = weakness;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getrobot_number() {
        return robot_number;
    }

    public void setrobot_number(String robot_number) {
        this.robot_number = robot_number;
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
        result = prime * result + ((robot_number == null) ? 0 : robot_number.hashCode());
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
        if (robot_number == null) {
            if (other.robot_number != null)
                return false;
        } else if (!robot_number.equals(other.robot_number))
            return false;
        return true;
    }
}
