package com.charlesedu.megamanapi.services;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.repositories.RobotMasterRepository;

// import jakarta.persistence.EntityNotFoundException;

@Service
public class RobotMasterService {
    
    @Autowired
    private RobotMasterRepository repository;

    public List<RobotMaster> findAll() {
        return repository.findAll();
    }

    // public RobotMaster findById(Long id) {
    //     Optional<RobotMaster> obj = repository.findById(id);

    //     return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    // }

    // public RobotMaster insert(RobotMaster obj) {
    //     return repository.save(obj);
    // }

    // public void delete(Long id) {
    //     try {
    //         if (repository.existsById(id)) {
    //             repository.deleteById(id);
    //         } else {
    //             throw new ResourceNotFoundException(id);
    //         }
    //     } catch (ResourceNotFoundException e) {
    //         throw new ResourceNotFoundException(id);
    //     } catch (DataIntegrityViolationException e) {
    //         throw new DatabaseException(e.getMessage());
    //     }
    // }

    // public RobotMaster update(Long id, RobotMaster obj) {
    //     try {
    //         RobotMaster entity = repository.getReferenceById(id);
    
    //         updateData(entity, obj);
    
    //         return repository.save(entity);
    //     } catch (EntityNotFoundException e) {
    //         throw new ResourceNotFoundException(id);
    //     }
    // }

    // private void updateData(RobotMaster entity, RobotMaster obj) {
    //     entity.setName(obj.getName());
    //     entity.setEmail(obj.getEmail());
    //     entity.setPhone(obj.getPhone());
    // }
// }
}
