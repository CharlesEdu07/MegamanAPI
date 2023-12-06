package com.charlesedu.megamanapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlesedu.megamanapi.entities.DefeatedRobot;
import com.charlesedu.megamanapi.entities.RobotList;
import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.repositories.IDefeatedRobotRepository;

@Service
public class DefeatedRobotService {

    @Autowired
    private IDefeatedRobotRepository defeatedRobotRepository;

    public DefeatedRobot save(DefeatedRobot defeatedRobot) {
        return defeatedRobotRepository.save(defeatedRobot);
    }

    public void delete(DefeatedRobot defeatedRobot) {
        defeatedRobotRepository.delete(defeatedRobot);
    }

    public List<DefeatedRobot> findAll() {
        return defeatedRobotRepository.findAll();
    }

    public DefeatedRobot findByIdRobotListAndIdRobotMaster(RobotList robotList, RobotMaster robotMaster) {
        return defeatedRobotRepository.findByIdRobotListAndIdRobotMaster(robotList, robotMaster);
    }

    public List<DefeatedRobot> findFirstScores(RobotMaster robotMaster) {
        return defeatedRobotRepository.findFirst10ById_RobotMasterOrderByDamageTakenAscTimeAsc(robotMaster);
    }
}
