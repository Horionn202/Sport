package com.example.Sport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Sport.repositories.equiposRepo;
import com.example.Sport.models.EquipoModel;
import java.util.List;

@Service
public class equiposService {

    @Autowired
    private equiposRepo repo;

 
    public List<EquipoModel> listarEquipos() {
        return repo.findAll();
    }

    public void guardarEquipo(EquipoModel equipo) {
        repo.save(equipo);
    }

    public void eliminarEquipo(Long id) {
        repo.deleteById(id);
    }
    public EquipoModel buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre)
                .orElse(null);
}

    public EquipoModel findbyId(Long id) {
        return repo.findById(id).orElse(null);
    }




}
