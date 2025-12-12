package com.example.Sport.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Sport.models.partidosModel;
import com.example.Sport.repositories.PartidosRepo;
import java.util.List;

@Service
public class partidosService {
    @Autowired
    private PartidosRepo repo;

    public List<partidosModel> listarPartidos() {
        return repo.findAll();
    }

    public void guardarPartido(partidosModel partido) {
        repo.save(partido);
    }

    public void eliminarPartido(Long id) {
        repo.deleteById(id);
    }



 
}
