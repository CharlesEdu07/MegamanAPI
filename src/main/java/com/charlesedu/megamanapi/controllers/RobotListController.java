package com.charlesedu.megamanapi.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.charlesedu.megamanapi.dto.RobotDTO;
import com.charlesedu.megamanapi.entities.DefeatedRobot;
import com.charlesedu.megamanapi.entities.RobotList;
import com.charlesedu.megamanapi.services.DefeatedRobotService;
import com.charlesedu.megamanapi.services.RobotListService;
import com.charlesedu.megamanapi.services.RobotMasterService;
import com.charlesedu.megamanapi.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
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
    private DefeatedRobotService defeatedRobotService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RobotDTO robotDTO, HttpServletRequest request) {
        var idUser = (UUID) request.getAttribute("idUser");

        var robotList = robotListService.findByUserId(idUser);

        if (robotList == null) {
            robotList = new RobotList();
            robotList.setUser(this.userService.findById(idUser));
            robotListService.save(robotList);
        }

        var robotMasterId = robotDTO.getId();

        var robotMaster = robotMasterService.findById(robotMasterId);

        if (robotMaster == null) {
            return ResponseEntity.badRequest().body("Robot Master not found");

        } else if (robotList.getDefeatedRobots().stream()
                .anyMatch(defeatedRobot -> defeatedRobot.getRobotMaster().getId().equals(robotMasterId))) {
            return ResponseEntity.badRequest().body("Robot Master already defeated");

        } else {
            robotMaster = robotMasterService.findById(robotMasterId);
        }

        var defeatedRobot = new DefeatedRobot(robotList, robotMaster, robotDTO.getDamageTaken(), robotDTO.getTime());
        var savedDefeatedRobot = defeatedRobotService.save(defeatedRobot);

        robotList.getDefeatedRobots().add(savedDefeatedRobot);

        return ResponseEntity.ok().body(robotList);
    }

    @GetMapping("/")
    public ResponseEntity<?> list(HttpServletRequest request) {
        var idUser = (UUID) request.getAttribute("idUser");

        var robotList = this.robotListService.findByUserId(idUser);

        return ResponseEntity.ok().body(robotList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id, HttpServletRequest request) {
        var idUser = (UUID) request.getAttribute("idUser");

        var robotList = this.robotListService.findByUserId(idUser);

        if (robotList == null) {
            return ResponseEntity.badRequest().body("Robot List not found");
        } else {
            var targetRobotMaster = robotMasterService.findById(id);

            if (targetRobotMaster == null) {
                return ResponseEntity.badRequest().body("Robot Master not found");
            }

            var defeatedRobot = this.defeatedRobotService.findByIdRobotListAndIdRobotMaster(robotList,
                    targetRobotMaster);

            robotList.getDefeatedRobots().remove(defeatedRobot);

            this.robotListService.save(robotList);

            this.defeatedRobotService.delete(defeatedRobot);
        }

        return ResponseEntity.ok().body(robotList);
    }
}
