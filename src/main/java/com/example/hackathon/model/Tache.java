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
@Table(name="tache_tab")

public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "desc_tache" )
    private String desc_equip;

    @Column(name = "date_execution")
    private String date_execution;

    @Column(name = "machine_execution")
    private String machine_execution;
}


