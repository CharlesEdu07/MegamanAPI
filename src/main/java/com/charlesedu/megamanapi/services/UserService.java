package com.charlesedu.megamanapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlesedu.megamanapi.entities.User;
import com.charlesedu.megamanapi.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
