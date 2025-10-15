package com.example.Sport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("/")
    public String verDashboard() {
        return "DasboardPrincipal";
    }

    @GetMapping("/login")
    public String verLogin() {
        return "IniciarSeccion";
    }

    @GetMapping("/registro-equipo")
    public String verRegistroEquipo() {
        return "RegistroEquipo";
    }

    @GetMapping("/registro-jugador")
    public String verRegistroJugador() {
        return "RegistroJugador";
    }

    @GetMapping("/dashboard-jugador")
    public String verDashboardJugador() {
        return "DashboardJugador";
    }
}
