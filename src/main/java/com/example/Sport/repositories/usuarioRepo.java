package com.example.Sport.repositories;

import com.example.Sport.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface usuarioRepo extends JpaRepository<UsuarioModel, Long> {

      Optional<UsuarioModel> findByEmail(String email);

}
