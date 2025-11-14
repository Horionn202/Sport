package com.example.Sport.repositories;

import org.springframework.stereotype.Repository;
import com.example.Sport.models.JugadorModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JugadorRepo extends JpaRepository<JugadorModel, Long> {

}
