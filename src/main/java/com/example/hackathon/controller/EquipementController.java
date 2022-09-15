package com.example.hackathon.controller;

import com.example.hackathon.exception.ResourceNotFoundExeption;
import com.example.hackathon.model.Equipement;
import com.example.hackathon.repository.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    @Autowired

    private EquipementRepository equipementRepository;


    //get all equipements API REST
    @GetMapping
    public List<Equipement> getAllEquipement(){
        return equipementRepository.findAll();
    }


    //Create equipement REST API
    @PostMapping
    public Equipement createEquipement(@RequestBody Equipement equipement){
        return equipementRepository.save(equipement);
    }

    //Get equipement by Id REST API
    @GetMapping("{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable long id){
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Equipement not exist whit id:" + id));
        return ResponseEntity.ok(equipement);
    }

    // Update equipement REST API
    @PutMapping("{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable long id, @RequestBody Equipement equipementDetails){
        Equipement updateEquipement = equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Equipement not exist whit id:" + id));

        updateEquipement.setName_equip(equipementDetails.getName_equip());
        updateEquipement.setDesc_equip(equipementDetails.getDesc_equip());
        updateEquipement.setPosition(equipementDetails.getPosition());
        updateEquipement.setTemps_fonctionnement(equipementDetails.getTemps_fonctionnement());

        equipementRepository.save(updateEquipement);
        return ResponseEntity.ok(updateEquipement);
    }

    // Delect equipement REST API
    public ResponseEntity<HttpStatus> delecteEquipement(long id){
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Equipement not exist whit this id:" + id));
        equipementRepository.delete(equipement);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
