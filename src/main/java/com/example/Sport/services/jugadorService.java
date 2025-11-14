package com.example.Sport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Sport.models.JugadorModel;
import com.example.Sport.repositories.JugadorRepo;
import java.util.List;  

@Service
public class jugadorService {
    @Autowired 
    private JugadorRepo repo;

    public List<JugadorModel> listarJugadores() {
        return repo.findAll();
    }

    public void guardarJugador(JugadorModel jugador) {
        repo.save(jugador);
    }

    public void eliminarJugador(Long id) {
        repo.deleteById(id);
    }

}
