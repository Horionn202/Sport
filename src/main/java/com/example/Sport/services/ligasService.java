package com.example.Sport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Sport.models.ligasModel;
import com.example.Sport.repositories.LigasRepo;
import java.util.List;

@Service
public class ligasService {
    @Autowired
    private LigasRepo repo;

    public List<ligasModel> listarLigas() {
        return repo.findAll();
    }

    public void guardarLiga(ligasModel liga) {
        repo.save(liga);
    }

    public void eliminarLiga(Long id) {
        repo.deleteById(id);
    }

    public ligasModel buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    
}
