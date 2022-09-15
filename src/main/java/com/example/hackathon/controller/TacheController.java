package com.example.hackathon.controller;

import com.example.hackathon.exception.ResourceNotFoundExeption;
import com.example.hackathon.model.Equipement;
import com.example.hackathon.model.Tache;
import com.example.hackathon.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    @Autowired

    private TacheRepository tacheRepository;

    //get all tache API REST
    @GetMapping
    public List<Tache> getAllTache(){
        return tacheRepository.findAll();
    }


    //Create tache REST API
    @PostMapping
    public Tache createTache(@RequestBody Tache tache){
        return tacheRepository.save(tache);
    }

    //Get tache by Id REST API
    @GetMapping("{id}")
    public ResponseEntity<Tache> getTacheById(@PathVariable long id){
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Tache not exist whit id:" + id));
        return ResponseEntity.ok(tache);
    }

    // Update tache REST API
    @PutMapping("{id}")
    public ResponseEntity<Tache> updateTache(@PathVariable long id, @RequestBody Tache tacheDetails){
        Tache updateTache = tacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Tache not exist whit id:" + id));

        updateTache.setDesc_tache(tacheDetails.getDesc_tache());
        updateTache.setDate_execution(tacheDetails.getDate_execution());
        updateTache.setMachine_execution(tacheDetails.getMachine_execution());

        tacheRepository.save(updateTache);
        return ResponseEntity.ok(updateTache);
    }

    // Delect tache REST API
    public ResponseEntity<HttpStatus> delecteTache(long id){
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Tache not exist whit this id:" + id));
        tacheRepository.delete(tache);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
