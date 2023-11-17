package com.charlesedu.megamanapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlesedu.megamanapi.entities.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
        public UserModel findByUsername(String username);
}