package com.example.hackathon;

import com.example.hackathon.model.Equipement;
import com.example.hackathon.model.Tache;
import com.example.hackathon.repository.EquipementRepository;
import com.example.hackathon.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HackathonApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }

    @Autowired
    private TacheRepository tacheRepository;

    @Override
    public void run(String... args) throws Exception {
        Tache tache = new Tache();
        tache.setDesc_tache("Defrichage");
        tache.setDate_execution("Lundi le 18 novembre");
        tache.setMachine_execution("Tronsoneuse");

        tacheRepository.save(tache);


    }
}
