package com.example.Sport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class usuarioController {

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

    // Página de registro jugador
    @GetMapping("/registro-jugador")
    public String verRegistroJugador() {
        return "4RegistroJugador";
    }

    // Página de registro jugador
    @GetMapping("/registro-equipo")
    public String verRegistroEquipo() {
        return "5RegistroEquipo";
    }

    // Página de dashboard jugador
    @GetMapping("/dashboard-jugador")
    public String verDashboardJugador() {
        return "6DashboardJugador";
    }
    
    // Página de dashboard entrenador
    @GetMapping("/dashboard-entrenador")
    public String verDashboardEntrenador() {
        return "7DashboardEntrenador";
    }

    // Página de dashboard administrador
    @GetMapping("/dashboard-administrador")
    public String verDashboardAdministrador() {
        return "8DashboardAdministrador";
    }

    // Página de listado de ligas
    @GetMapping("/listado-ligas")
    public String verListadoLigas() {
        return "9ListadoLigas";
    }

    // Pagina Calendario
    @GetMapping("/calendario")
    public String verCalendario(){
        return "10Calendario";
    }
    
    // Pagina Estadistica Jugador
    @GetMapping("/estadistica")
    public String verEstadisticaJugador(){
        return "11EstadisticaJugador";
    }

    // Pagina Equipos

    @GetMapping("/Equipos")
    public String verEquipos(){
        return "12Equipos";
    }


    // Pagina de configuracion

    @GetMapping("/configuracion")
    public String verConfiguracion(){
        return "13Configuracion";
    }

    // Pagina de Entrenamiento

    @GetMapping("entrenamiento")
    public String verEntrenamiento(){
        return "14Entrenamientos";
    }
}
