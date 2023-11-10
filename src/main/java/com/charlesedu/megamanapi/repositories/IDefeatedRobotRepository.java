package com.charlesedu.megamanapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlesedu.megamanapi.entities.DefeatedRobot;

@Repository
public interface IDefeatedRobotRepository extends JpaRepository<DefeatedRobot, UUID> {
    
}
