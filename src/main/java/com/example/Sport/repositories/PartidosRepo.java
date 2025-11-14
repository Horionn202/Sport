package com.example.Sport.repositories;

import org.springframework.stereotype.Repository;
import com.example.Sport.models.partidosModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PartidosRepo extends JpaRepository<partidosModel, Long> {

}
