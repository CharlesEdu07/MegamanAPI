package com.charlesedu.megamanapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesedu.megamanapi.entities.UserModel;
import com.charlesedu.megamanapi.services.UserService;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserModel userModel) {
        var user = this.service.findByUsername(userModel.getUsername());

        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existente com este username");
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(passwordHashred);

        var userCreated = this.service.create(userModel);

        String userCreatedInformation = "Usuário criado com sucesso! Username: " + userCreated.getUsername();

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreatedInformation);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> findAll() {
        List<UserModel> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }
}
