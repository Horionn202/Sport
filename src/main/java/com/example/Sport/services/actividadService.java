package com.example.Sport.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Sport.repositories.actividadRepository;
import com.example.Sport.models.actividadModel;
import java.util.List;
import com.example.Sport.models.UsuarioModel;

@Service
public class actividadService {
    @Autowired
    private actividadRepository repo;

    
    // Guardar una actividad para un usuario específico
    public void guardarActividad(UsuarioModel usuario, String descripcion) {
        actividadModel actividad = new actividadModel();
        actividad.setUsuario(usuario); // Pasamos el UsuarioModel completo
        actividad.setDescripcion(descripcion);
        actividad.setFecha(LocalDateTime.now());

        repo.save(actividad);
    }

    // Obtener las últimas 10 actividades de un usuario
    public List<actividadModel> ultimasActividades(UsuarioModel usuario) {
        return repo.findTop10ByUsuarioOrderByFechaDesc(usuario);
    }
    public void eliminarPorUsuario(Long usuarioId) {
        repo.deleteByUsuarioId(usuarioId);
    }

    public List<actividadModel> listar() {
        return repo.findAll();
    }


}
