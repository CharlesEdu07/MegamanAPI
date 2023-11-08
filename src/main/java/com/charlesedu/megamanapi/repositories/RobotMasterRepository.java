package com.charlesedu.megamanapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlesedu.megamanapi.entities.RobotMaster;
import java.util.List;
import java.util.UUID;

@Repository
public interface RobotMasterRepository extends JpaRepository<RobotMaster, UUID> {
    public List<RobotMaster> findByOrderByName();

    public List<RobotMaster> findBySeries(String series);
}
