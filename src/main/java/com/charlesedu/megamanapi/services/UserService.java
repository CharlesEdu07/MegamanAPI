package com.charlesedu.megamanapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlesedu.megamanapi.entities.UserModel;
import com.charlesedu.megamanapi.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public UserModel create(UserModel userModel) {
        return repository.save(userModel);
    }

    public UserModel findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
