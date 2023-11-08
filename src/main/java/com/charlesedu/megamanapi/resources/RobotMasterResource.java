package com.charlesedu.megamanapi.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.services.RobotMasterService;

@RestController
@RequestMapping(value = "/robotmasters")
public class RobotMasterResource {

    @Autowired
    private RobotMasterService service;

    @GetMapping
    public ResponseEntity<List<RobotMaster>> findAll() {
        List<RobotMaster> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/series/{series}")
    public ResponseEntity<List<RobotMaster>> findBySeries(@PathVariable String series) {
        List<RobotMaster> list = service.findBySeries(series);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/sorted")
    public ResponseEntity<List<RobotMaster>> findAllSorted() {
        List<RobotMaster> list = service.findAllSorted();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RobotMaster> findById(@PathVariable UUID id) {
        RobotMaster obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<RobotMaster> insert(@RequestBody RobotMaster obj) {
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RobotMaster> update(@PathVariable UUID id, @RequestBody RobotMaster obj) {
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
