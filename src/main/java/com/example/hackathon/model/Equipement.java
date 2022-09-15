package com.example.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="equipement_tab")
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_equip")
    private String name_equip;

    @Column(name = "desc_equip" )
    private String desc_equip;

    @Column(name = "temps_fonctionnement")
    private String temps_fonctionnement;

    @Column(name = "position")
    private String position;
}
