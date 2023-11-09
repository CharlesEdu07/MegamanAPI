package com.charlesedu.megamanapi.controllers;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charlesedu.megamanapi.entities.DefeatedRobot;
import com.charlesedu.megamanapi.entities.RobotList;
import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.services.RobotListService;
import com.charlesedu.megamanapi.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/robotlist")
public class RobotListController {

    @Autowired
    private RobotListService robotListService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody RobotMaster robotMaster,
            @RequestParam("damage") Integer damageTaken,
            @RequestParam("time") LocalTime time, HttpServletRequest request) {
        var idUser = (UUID) request.getAttribute("idUser");

        var robotList = new RobotList();

        System.out.println(robotMaster);

        robotList.setUser(this.userService.findById(idUser));
        robotList.getDefeatedRobots().add(new DefeatedRobot(robotList, robotMaster, damageTaken, time));

        return ResponseEntity.ok(robotList);
    }
}
