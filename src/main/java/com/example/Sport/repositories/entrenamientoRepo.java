package com.example.Sport.repositories;

import com.example.Sport.models.entrenamientoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface entrenamientoRepo extends JpaRepository<entrenamientoModel, Long> {
 
}