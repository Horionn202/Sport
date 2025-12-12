package com.example.Sport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Sport.models.EquipoModel;
import java.util.Optional;

@Repository
public interface equiposRepo extends JpaRepository<EquipoModel, Long> {

     Optional<EquipoModel> findByNombre(String nombre);
}
