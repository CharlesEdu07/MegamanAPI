package com.charlesedu.megamanapi.dto;

import java.time.LocalTime;
import java.util.UUID;

public class RobotDTO {
    private UUID id;
    private Integer damageTaken;
    private LocalTime time;

    public RobotDTO() {
    }

    public RobotDTO(UUID id, Integer damageTaken, LocalTime time) {
        this.id = id;
        this.damageTaken = damageTaken;
        this.time = time;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
