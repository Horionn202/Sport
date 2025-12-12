package com.example.Sport.services;

import com.example.Sport.models.JugadorModel;
import com.example.Sport.models.entrenamientoModel;
import com.example.Sport.repositories.entrenamientoRepo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class entreamientoService {

    @Autowired
    private entrenamientoRepo repo;


    public List getAllEntrenamientos() {
        return repo.findAll();
    }

    public entrenamientoModel saveEntrenamiento (entrenamientoModel entrenamiento) {
        return repo.save(entrenamiento);
    }

    public entrenamientoModel buscarporID(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminarEntrenamiento(Long id) {
        repo.deleteById(id);
    }

    public entrenamientoModel obtenerporID(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<entrenamientoModel> listarEntrenamientosPorEntrenador(String nombre) {
        return repo.findByEntrenador(nombre);
    }
    
    public List<entrenamientoModel> listarTodos() {
        return repo.findAllByOrderByFechaAsc();
    }

}
