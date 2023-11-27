package com.charlesedu.megamanapi.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesedu.megamanapi.entities.DefeatedRobot;
import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.entities.Score;
import com.charlesedu.megamanapi.repositories.IDefeatedRobotRepository;
import com.charlesedu.megamanapi.services.RobotMasterService;
import com.charlesedu.megamanapi.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/robotmasters")
public class RobotMasterController {

    @Autowired
    private RobotMasterService service;

    @Autowired
    private IDefeatedRobotRepository defeatedRobotRepository;

    @GetMapping
    public ResponseEntity<List<RobotMaster>> findAll() {
        List<RobotMaster> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/series/{series}")
    public ResponseEntity<List<RobotMaster>> findBySeries(@PathVariable String series) {
        List<RobotMaster> list = service.findBySeries(series);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/sorted")
    public ResponseEntity<List<RobotMaster>> findAllSorted() {
        List<RobotMaster> list = service.findAllSorted();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RobotMaster> findById(@PathVariable UUID id) {
        RobotMaster obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/score/{id}")
    public ResponseEntity<List<Score>> findAllDefeatedRobots(@PathVariable UUID id) {
        RobotMaster robotMaster = service.findById(id);

        if (robotMaster == null) {
            throw new ResourceNotFoundException("RobotMaster not found with id: " + id);
        }

        List<DefeatedRobot> list = defeatedRobotRepository
                .findFirst10ById_RobotMasterOrderByDamageTakenAscTimeAsc(robotMaster);

        List<Score> scores = list.stream()
                .map(x -> new Score(
                        x.getRobotList().getUser(),
                        x.getRobotMaster(),
                        x.getDamageTaken(),
                        x.getTime()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(scores);
    }
}
