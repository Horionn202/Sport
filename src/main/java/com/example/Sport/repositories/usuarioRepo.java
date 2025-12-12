package com.example.Sport.repositories;

import com.example.Sport.models.JugadorModel;
import com.example.Sport.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface usuarioRepo extends JpaRepository<UsuarioModel, Long> {

      Optional<UsuarioModel> findByEmail(String email);
      List<UsuarioModel> findByEquipo(String equipo);

}
