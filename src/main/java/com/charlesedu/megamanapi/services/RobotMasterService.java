package com.charlesedu.megamanapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.repositories.IRobotMasterRepository;
import com.charlesedu.megamanapi.services.exceptions.DatabaseException;
import com.charlesedu.megamanapi.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RobotMasterService {

    @Autowired
    private IRobotMasterRepository repository;

    public List<RobotMaster> findAll() {
        return repository.findAll();
    }

    public List<RobotMaster> findAllSorted() {
        return repository.findByOrderByName();
    }

    public List<RobotMaster> findBySeries(String series) {
        return repository.findBySeries(series);
    }

    public RobotMaster findById(UUID id) {
        Optional<RobotMaster> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public RobotMaster insert(RobotMaster obj) {
        return repository.save(obj);
    }

    public void delete(UUID id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public RobotMaster update(UUID id, RobotMaster obj) {
        try {
            RobotMaster entity = repository.getReferenceById(id);

            updateData(entity, obj);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(RobotMaster entity, RobotMaster obj) {
        entity.setSeries(obj.getSeries());
        entity.setRobotNumber(obj.getRobotNumber());
        entity.setName(obj.getName());
        entity.setWeapon(obj.getWeapon());
        entity.setAvatar(obj.getAvatar());
        entity.setSprite(obj.getSprite());
        entity.setWeakness(obj.getWeakness());
    }
}
