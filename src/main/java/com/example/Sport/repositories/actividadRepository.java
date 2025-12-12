package com.example.Sport.repositories;

import org.springframework.stereotype.Repository;

import com.example.Sport.models.UsuarioModel;
import com.example.Sport.models.actividadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface actividadRepository extends JpaRepository<actividadModel, Long> {

    List<actividadModel> findTop10ByUsuarioOrderByFechaDesc(UsuarioModel usuario);
    @Modifying
    @Transactional
    @Query("DELETE FROM actividadModel a WHERE a.usuario.id = :usuarioId")
    void deleteByUsuarioId(@Param("usuarioId") Long usuarioId);
}