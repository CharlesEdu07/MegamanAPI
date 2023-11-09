package com.charlesedu.megamanapi.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_list_robots")
public class RobotList {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private LocalDateTime moment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @OneToMany(mappedBy = "id.listRobot")
    private Set<DefeatedRobot> defeatedRobots = new HashSet<>();

    public RobotList() {
    }

    public RobotList(UUID id, LocalDateTime moment, UserModel user) {
        this.id = id;
        this.moment = moment;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Set<DefeatedRobot> getDefeatedRobots() {
        return defeatedRobots;
    }

    public void setDefeatedRobots(Set<DefeatedRobot> defeatedRobots) {
        this.defeatedRobots = defeatedRobots;
    }
}
