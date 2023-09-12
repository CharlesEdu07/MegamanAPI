package com.charlesedu.megamanapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charlesedu.megamanapi.entities.RobotMaster;
import java.util.List;

public interface RobotMasterRepository extends JpaRepository<RobotMaster, Long> {
    public List<RobotMaster> findByOrderByName();

    public List<RobotMaster> findBySeries(String series);
}
