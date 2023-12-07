package com.charlesedu.megamanapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesedu.megamanapi.dto.UserDTO;
import com.charlesedu.megamanapi.entities.UserModel;
import com.charlesedu.megamanapi.services.UserService;

import at.favre.lib.crypto.bcrypt.BCrypt;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserModel userModel) {
        var user = this.service.findByUsername(userModel.getUsername());

        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existente com este username");
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(passwordHashred);

        var userCreated = this.service.create(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        var user = this.service.findByUsername(userDTO.getUsername());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado");
        }

        var passwordVerify = BCrypt.verifyer().verify(userDTO.getPassword().toCharArray(), user.getPassword());

        if (!passwordVerify.verified) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha incorreta");
        }

        return ResponseEntity.ok(user);
    }
}
