package com.example.Sport.repositories;
import com.example.Sport.models.ligasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigasRepo extends JpaRepository<ligasModel, Long> {}
