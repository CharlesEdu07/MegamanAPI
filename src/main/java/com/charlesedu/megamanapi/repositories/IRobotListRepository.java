package com.charlesedu.megamanapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charlesedu.megamanapi.entities.RobotList;

@Repository
@RequestMapping("/robotlist")
public interface IRobotListRepository extends JpaRepository<RobotList, UUID> {

}
