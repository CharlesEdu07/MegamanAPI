package com.charlesedu.megamanapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesedu.megamanapi.entities.User;
import com.charlesedu.megamanapi.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    
    @Autowired
    private UserService service;

    // @PostMapping(value = "/")
    // public ResponseEntity<User> create(@RequestBody User obj) {
    //     var user = this.service.findByUsername(obj.getUsername());

    //     if (user != null) {
    //         return ResponseEntity.badRequest().build();
    //     }

    //     var newUser = this.service.create(obj);
    // }

}
