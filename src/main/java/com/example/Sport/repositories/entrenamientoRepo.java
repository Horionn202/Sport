package com.example.Sport.repositories;

import com.example.Sport.models.entrenamientoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;  


@Repository
public interface entrenamientoRepo extends JpaRepository<entrenamientoModel, Long> {
     List<entrenamientoModel> findByEntrenador(String entrenador);
     
   List<entrenamientoModel> findAllByOrderByFechaAsc();
}