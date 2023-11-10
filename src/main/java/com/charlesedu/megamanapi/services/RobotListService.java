package com.charlesedu.megamanapi.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlesedu.megamanapi.entities.RobotList;
import com.charlesedu.megamanapi.repositories.IRobotListRepository;

@Service
public class RobotListService {

    @Autowired
    private IRobotListRepository repository;

    public RobotList save(RobotList robotList) {
        return repository.save(robotList);
    }

    public RobotList findByUserId(UUID idUser) {
        return repository.findByUserId(idUser);
    }
}
