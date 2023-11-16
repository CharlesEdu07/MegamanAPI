package com.charlesedu.megamanapi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.entities.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);

    @Query("SELECT u FROM UserModel u " +
            "JOIN u.robotList rl " +
            "JOIN rl.defeatedRobots dr " +
            "JOIN dr.id.robotMaster rm " +
            "WHERE (dr.damageTaken, dr.time) = (" +
            "   SELECT MIN(dr2.damageTaken), MIN(dr3.time) " +
            "   FROM DefeatedRobot dr2, DefeatedRobot dr3 " +
            "   WHERE dr2.id.robotList = rl AND dr3.id.robotMaster = rm)" +
            "ORDER BY MIN(dr.damageTaken) ASC, MIN(dr.time) ASC")
    List<UserModel> findUsersWithMinimumDamageAndTimeWithLimit(
            @Param("robotMaster") RobotMaster robotMaster);
}