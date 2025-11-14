package com.example.Sport.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.Sport.services.usuarioService;

import com.example.Sport.models.UsuarioModel;

@Controller
public class usuarioController {

    @Autowired
    private usuarioService usuarioService;

    // Página de inicio
    @GetMapping("/")
    public String verPaginaDeInicio() {
        return "1Inicio";
    }

    // Página de iniciar sesión
    @GetMapping("/login")
    public String verLogin() {
        return "2IniciarSesion";
    }

    // Página de registro
     @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "3registro";
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

    @PostMapping("/registro")
    public String guardarUsuario(@ModelAttribute UsuarioModel usuario) {

        usuario.setRol("USER");
        usuarioService.saveUsuario(usuario);  

        return "redirect:/login";
    }


    @PostMapping("/login")
    public String iniciarSesion(@RequestParam("email") String email,
                                @RequestParam("contrasena") String contrasena,
                               Model model) {
        var usuarioOpt = usuarioService.obtenerPorEmail(email);

        if (usuarioOpt.isPresent()) {
            UsuarioModel usuario = usuarioOpt.get();
            if (usuario.getContrasena().equals(contrasena)) {
                // Autenticación exitosa, redirigir según el rol
                String rol = usuario.getRol();
                if ("ADMIN".equals(rol)) {
                    return "redirect:/dashboard-administrador";
                } else if ("ENTRENADOR".equals(rol)) {
                    return "redirect:/dashboard-entrenador";
                } else {
                    return "redirect:/dashboard-jugador";
                }
            } else {
                model.addAttribute("error", "Contraseña incorrecta");
                return "/login";
            }
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "/login";
        }
    }


}
