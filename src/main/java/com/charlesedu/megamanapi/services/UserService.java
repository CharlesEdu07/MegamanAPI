package com.charlesedu.megamanapi.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlesedu.megamanapi.entities.UserModel;
import com.charlesedu.megamanapi.repositories.IUserRepository;
import com.charlesedu.megamanapi.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    @Autowired
    private IUserRepository repository;

    public UserModel create(UserModel userModel) {
        return repository.save(userModel);
    }

    public UserModel findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public UserModel findById(UUID id) {
        Optional<UserModel> user = repository.findById(id);

        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
