package com.charlesedu.megamanapi.controllers;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charlesedu.megamanapi.entities.DefeatedRobot;
import com.charlesedu.megamanapi.entities.RobotList;
import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.repositories.IDefeatedRobotRepository;
import com.charlesedu.megamanapi.services.RobotListService;
import com.charlesedu.megamanapi.services.RobotMasterService;
import com.charlesedu.megamanapi.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/robotlist")
public class RobotListController {

    @Autowired
    private RobotListService robotListService;

    @Autowired
    private UserService userService;

    @Autowired
    private RobotMasterService robotMasterService;

    @Autowired
    private IDefeatedRobotRepository defeatedRobotRepository;

    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody RobotMaster robotMaster,
            @RequestParam("damage") Integer damageTaken,
            @RequestParam("time") LocalTime time, HttpServletRequest request) {
        var idUser = (UUID) request.getAttribute("idUser");

        var robotList = robotListService.findByUserId(idUser);

        if (robotList == null) {
            robotList = new RobotList();
            robotList.setUser(this.userService.findById(idUser));
            robotListService.save(robotList);
        }

        var robotMasterId = robotMaster.getId();

        if (robotMasterService.findById(robotMaster.getId()) == null) {
            return ResponseEntity.badRequest().body("Robot Master not found");
        } else if (robotList.getDefeatedRobots().stream()
                .anyMatch(defeatedRobot -> defeatedRobot.getRobotMaster().getId().equals(robotMasterId))) {
            return ResponseEntity.badRequest().body("Robot Master already defeated");
        } else {
            robotMaster = robotMasterService.findById(robotMaster.getId());
        }

        var defeatedRobot = new DefeatedRobot(robotList, robotMaster, damageTaken, time);
        var savedDefeatedRobot = defeatedRobotRepository.save(defeatedRobot);

        robotList.getDefeatedRobots().add(savedDefeatedRobot);

        return ResponseEntity.ok().body(robotList);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(HttpServletRequest request) {
        var idUser = (UUID) request.getAttribute("idUser");

        var robotList = this.robotListService.findByUserId(idUser);

        return ResponseEntity.ok().body(robotList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id, HttpServletRequest request) {
        var idUser = (UUID) request.getAttribute("idUser");

        var robotList = this.robotListService.findByUserId(idUser);

        System.out.println("Dudu");

        if (robotList == null) {
            return ResponseEntity.badRequest().body("Robot List not found");
        } else {
            var targetRobotMaster = robotMasterService.findById(id);

            if (targetRobotMaster == null) {
                return ResponseEntity.badRequest().body("Robot Master not found");
            }

            var defeatedRobot = this.defeatedRobotRepository.findByIdRobotListAndIdRobotMaster(robotList,
                    targetRobotMaster);

            robotList.getDefeatedRobots().remove(defeatedRobot);
        }

        return ResponseEntity.ok().body(robotList);
    }
}
