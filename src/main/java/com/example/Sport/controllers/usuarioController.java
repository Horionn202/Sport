package com.example.Sport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    // Página de inicio
    @GetMapping("/")
    public String verPaginaDeInicio() {
        return "1Inicio";
    }

    // Página de iniciar sesión
    @GetMapping("/iniciar-sesion")
    public String verLogin() {
        return "2IniciarSesion";
    }

    // Página de registro
    @GetMapping("/registro")
    public String verRegistro() {
        return "3Registro";
    }
}
