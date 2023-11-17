package com.charlesedu.megamanapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlesedu.megamanapi.entities.DefeatedRobot;
import com.charlesedu.megamanapi.entities.RobotList;
import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.entities.pk.DefeatedRobotPK;

@Repository
public interface IDefeatedRobotRepository extends JpaRepository<DefeatedRobot, DefeatedRobotPK> {
    public DefeatedRobot findByIdRobotListAndIdRobotMaster(RobotList robotList, RobotMaster robotMaster);

    public List<DefeatedRobot> findFirst10ById_RobotMasterOrderByDamageTakenAscTimeAsc(RobotMaster robotMaster);
}
