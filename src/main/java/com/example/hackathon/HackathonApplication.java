package com.example.hackathon;

import com.example.hackathon.model.Equipement;
import com.example.hackathon.repository.EquipementRepository;
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
    private EquipementRepository equipementRepository;

    @Override
    public void run(String... args) throws Exception {
        Equipement equipement = new Equipement();
        equipement.setName_equip("Tracteur");
        equipement.setDesc_equip("Utiliser pour labourer sur des grandes espaces");
        equipement.setTemps_fonctionnement("10h30min");
        equipement.setPosition("Douala");

        equipementRepository.save(equipement);

        Equipement equipement1 = new Equipement();
        equipement1.setName_equip("Capteur PH");
        equipement1.setDesc_equip("Utiliser pour mesurer le degres en nutriment du sol");
        equipement1.setTemps_fonctionnement("5h15min");
        equipement1.setPosition("Yaounde");
        equipementRepository.save(equipement1);
    }
}
