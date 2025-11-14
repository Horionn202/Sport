package com.example.Sport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Sport.models.UsuarioModel;   
import com.example.Sport.repositories.usuarioRepo;
import java.util.*;;

@Service
public class usuarioService {

    @Autowired
    private usuarioRepo repo;

    public List<UsuarioModel> listarUsuarios() {
        return repo.findAll();
    }

    public UsuarioModel saveUsuario (UsuarioModel usuario) {
        return repo.save(usuario);
    }

    public UsuarioModel buscarporID(Long id) {
        return repo.findById(id).orElse(null);
    }
    public void eliminarUsuario(Long id) {
        repo.deleteById(id);
    }

    public Optional<UsuarioModel> obtenerPorEmail(String email) {
        return repo.findByEmail(email);
    }

}

