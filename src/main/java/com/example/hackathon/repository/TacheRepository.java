package com.example.hackathon.repository;

import com.example.hackathon.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}
