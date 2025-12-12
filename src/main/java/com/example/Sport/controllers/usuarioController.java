package com.example.Sport.controllers;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.example.Sport.services.equiposService;
import com.example.Sport.services.jugadorService;
import com.example.Sport.services.ligasService;
import com.example.Sport.services.partidosService;
import com.example.Sport.services.usuarioService;
import com.example.Sport.services.entreamientoService;

import jakarta.servlet.http.HttpSession;

import com.example.Sport.models.EquipoModel;
import com.example.Sport.models.UsuarioModel;
import com.example.Sport.models.entrenamientoModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Sport.services.actividadService;
import com.example.Sport.models.actividadModel;
import jakarta.transaction.Transactional;
import com.example.Sport.models.ligasModel;



@Controller
public class usuarioController {

    @Autowired
    private usuarioService usuarioService;
     @Autowired
    private partidosService partidosService;
    @Autowired
    private jugadorService jugadorService;
    @Autowired
    private ligasService ligasService;
    @Autowired
    private equiposService equiposService;
    @Autowired
    private entreamientoService entrenamientoService;
    @Autowired
    private actividadService actividadService;

    @Autowired
    private equiposService equipoService;

    // Página de inicio
    @GetMapping("/")
    public String verPaginaDeInicio(Model model) {
            model.addAttribute("usuarios", usuarioService.listarUsuarios());
            model.addAttribute("jugadores", jugadorService.listarJugadores());
            model.addAttribute("ligas", ligasService.listarLigas());
            model.addAttribute("equipos", equiposService.listarEquipos());
        return "1Inicio";
    }

    @GetMapping("/inicio")
    public String verInicio(Model model) {

            model.addAttribute("usuarios", usuarioService.listarUsuarios());
            model.addAttribute("jugadores", jugadorService.listarJugadores());
            model.addAttribute("ligas", ligasService.listarLigas());
            model.addAttribute("equipos", equiposService.listarEquipos());
        return "inicioLog";
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
    public String verDashboardJugador(HttpSession session, Model model) {

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");

        if (usuario == null) {
            return "redirect:/login"; 
        }
            model.addAttribute("usuario", usuario);

          
            List<actividadModel> actividades = actividadService.ultimasActividades(usuario);
            model.addAttribute("actividades", actividades);

        model.addAttribute("usuario", usuario);

        return "6DashboardJugador";
    }

    // Página de dashboard entrenador
    @GetMapping("/dashboard-entrenador")
    public String verDashboardEntrenador(HttpSession session, Model model) {

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/login"; 
        }

        // Equipo del entrenador
        String nombreEquipo = usuario.getEquipo();

        // Lista de compañeros del mismo equipo
        List<UsuarioModel> misCompañeros = usuarioService.listarPorEquipo(nombreEquipo);

        // Entrenamientos asignados al entrenador
        List<entrenamientoModel> entrenamientos =
                entrenamientoService.listarEntrenamientosPorEntrenador(usuario.getNombre());

        // Obtener estadísticas del equipo (ganados/perdidos)
        EquipoModel equipoModel = equiposService.buscarPorNombre(nombreEquipo);

        int ganados = 0;
        int perdidos = 0;

        if (equipoModel != null) {
            if (equipoModel.getPartidosGanados() != null) {
                ganados = equipoModel.getPartidosGanados();
            }
            if (equipoModel.getPartidosPerdidos() != null) {
                perdidos = equipoModel.getPartidosPerdidos();
            }
        }

        // Enviar datos a la vista
        model.addAttribute("usuario", usuario);
        model.addAttribute("misCompañeros", misCompañeros);
        model.addAttribute("entrenamiento", entrenamientos);
        model.addAttribute("ganados", ganados);
        model.addAttribute("perdidos", perdidos);
        model.addAttribute("partidosGanados", ganados);
        model.addAttribute("partidosPerdidos", perdidos);

        // Opcional: mostrar mensaje si no tiene equipo
        if (equipoModel == null) {
            model.addAttribute("mensajeEquipo", "Aún no tienes un equipo asignado.");
        }

        return "7DashboardEntrenador";
    }


        @GetMapping("/entrenoForm")
        public String verFormularioEntreno(HttpSession session, Model model) {

            UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");

            if (usuario == null) {
                return "redirect:/login";
            }

            model.addAttribute("usuario", usuario);
            model.addAttribute("entrenamiento", new entrenamientoModel());

            return "formularioEntreno";
        }
       
        // Página de dashboard administrador
        @GetMapping("/dashboard-administrador")
        public String verdashboard(HttpSession session, Model model) {

            UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");

            if (usuario == null) {
                return "redirect:/login";
            }
             List<actividadModel> actividades = actividadService.listar();
            model.addAttribute("actividades", actividades);

            model.addAttribute("usuario", usuario);

            model.addAttribute("usuarios", usuarioService.listarUsuarios());
            model.addAttribute("jugadores", jugadorService.listarJugadores());
            model.addAttribute("ligas", ligasService.listarLigas());
            model.addAttribute("equipos", equiposService.listarEquipos());
            return "8DashboardAdministrador";
        }


        // Página de listado de ligas
        @GetMapping("/listado-ligas")
        public String listadoLigas(Model model) {
        model.addAttribute("ligas", ligasService.listarLigas());
        return "9ListadoLigas";
    }

        @GetMapping("/ligas")
        public String verligas(Model model){
            model.addAttribute("ligas", ligasService.listarLigas());
            
            return "ligas";
        }


        // Pagina Calendario
        @GetMapping("/calendario")
        public String verCalendario(){
        return "10Calendario";
    }
    
        // Pagina Estadistica Jugador
        @GetMapping("/estadistica")
        public String verEstadisticaJugador(HttpSession session, Model model){
            UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");

            if (usuario == null) {
                return "redirect:/login"; // por seguridad
            }

        List<String> fechas = null;
        if (usuario.getPartidos() != null && !usuario.getPartidos().isEmpty()) {
            fechas = Arrays.asList(usuario.getPartidos().split(","));
        }

        // GOLES (String → List<Integer>)
        List<Integer> goles = null;
        if (usuario.getGoles() != null && !usuario.getGoles().isEmpty()) {
            goles = Arrays.stream(usuario.getGoles().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        }

        // ASISTENCIAS (String → List<Integer>)
        List<Integer> asistencias = null;
        if (usuario.getAsistencias() != null && !usuario.getAsistencias().isEmpty()) {
            asistencias = Arrays.stream(usuario.getAsistencias().split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
        }

        // Verificar si el usuario tiene datos reales
        boolean tieneDatos = (fechas != null && !fechas.isEmpty());

        model.addAttribute("tieneDatos", tieneDatos);
        model.addAttribute("fechas", fechas);
        model.addAttribute("goles", goles);
        model.addAttribute("asistencias", asistencias);
        model.addAttribute("usuario", usuario);


            
            return "11EstadisticaJugador";
        }

    // Pagina Equipos

    @GetMapping("/Equipos")
    public String verEquipos(Model model){
        model.addAttribute("equipo", equiposService.listarEquipos());
        
        return "12Equipos"; 
    }


    // Pagina de configuracion

        @GetMapping("/configuracion")
        public String verConfiguracion(HttpSession session, Model model){
            UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");
            if(usuario == null){
                return "redirect:/login";
            }
            model.addAttribute("usuario", usuario);
            return "13Configuracion";
        }

    // Pagina de Entrenamiento

    @GetMapping("/entrenamientos")
    public String verEntrenamientos(Model model) {
        List<entrenamientoModel> entrenamientos = entrenamientoService.listarTodos();
        model.addAttribute("entrenamientos", entrenamientos);
        return "14Entrenamientos"; 
    }

@GetMapping("/crearEquipo")
public String mostrarFormularioCrearEquipo(Model model) {
    model.addAttribute("equipo", new EquipoModel()); // Esto es obligatorio
    return "crearEquipo";
}


    @PostMapping("/unirseEquipo")
    public String unirseEquipo(@RequestParam("nombreEquipo") String nombreEquipo, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");
        if (usuario == null) {
            return "redirect:/login"; // Si no hay sesión, redirige al login
        }

     
        usuario.setEquipo(nombreEquipo);
        usuarioService.saveUsuario(usuario); 

  
        session.setAttribute("usuarioActual", usuario);

         actividadService.guardarActividad(usuario, "Se unió al equipo " + nombreEquipo);

        EquipoModel equipo = equiposService.buscarPorNombre(nombreEquipo);
            if (equipo != null) {
                // Aumentar cantidad de jugadores
                Integer cant = equipo.getCantJugadores();
                equipo.setCantJugadores((cant != null ? cant : 0) + 1);
                equiposService.guardarEquipo(equipo);

                // Asignar equipo al usuario
                usuario.setEquipo(nombreEquipo);
                usuarioService.saveUsuario(usuario);

                // Registrar actividad
                actividadService.guardarActividad(usuario, "Se unió al equipo " + nombreEquipo);
            }

        if ("ENTRENADOR".equalsIgnoreCase(usuario.getRol())) {
            return "redirect:/dashboard-entrenador";
        } else {
            return "redirect:/dashboard-jugador";
        }
    }

    @PostMapping("/guardarEquipo")
    public String guardarEquipo(@ModelAttribute EquipoModel equipo,
                            HttpSession session) {

    UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");
    
                            
    if (usuario == null) {
        return "redirect:/login";
    }

    // Asignar el entrenador actual al equipo
    equipo.setNombreEntrenador(usuario.getNombre());

    equipoService.guardarEquipo(equipo);
    actividadService.guardarActividad(usuario, "Creó el equipo " + equipo.getNombre());
    
    return "redirect:/dashboard-entrenador";
}
    @PostMapping("/registro")
    public String guardarUsuario(@ModelAttribute UsuarioModel usuario) {

        //usuario.setRol("USER");
        usuarioService.saveUsuario(usuario);  

        actividadService.guardarActividad(usuario, "Creó su cuenta");
        return "redirect:/login";
    }

    @PostMapping("/guardarEntreno")
    public String guardarEntrenamiento(@ModelAttribute("entrenamiento") entrenamientoModel entrenamiento,
                                    HttpSession session) {

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioActual");

        if (usuario == null) {
            return "redirect:/login";
        }
        

        // Asignar el entrenamiento al entrenador actual
        entrenamiento.setEntrenador(usuario.getNombre());

        entrenamientoService.saveEntrenamiento(entrenamiento);

        return "redirect:/dashboard-entrenador";
    }
    




    @PostMapping("/login")
    public String iniciarSesion(@RequestParam("email") String email,
                                @RequestParam("contrasena") String contrasena,
                                Model model,
                                HttpSession session) {

        var usuarioOpt = usuarioService.obtenerPorEmail(email);

        if (usuarioOpt.isPresent()) {
            UsuarioModel usuario = usuarioOpt.get();
            if (usuario.getContrasena().equals(contrasena)) {

                // 🔥 GUARDAMOS EL USUARIO EN SESIÓN
                session.setAttribute("usuarioActual", usuario);

                // Redirigir según rol
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
                return "2IniciarSesion";
            }
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "2IniciarSesion";
        }
    }

    @PostMapping("/listado-ligas/eliminar/{id}")
    public String eliminarLiga(@PathVariable long id){
        ligasService.eliminarLiga(id);
        return "redirect:/dashboard-administrador";
    }

    @PostMapping("/admin/usuario/eliminar/{id}")
    @Transactional
    public String eliminarUsuario(@PathVariable Long id) {
        actividadService.eliminarPorUsuario(id);
        usuarioService.eliminarUsuario(id);
        return "redirect:/dashboard-administrador";
    }


    
        @GetMapping("/admin/usuario/editar/{id}")
        public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
            UsuarioModel usuario = usuarioService.buscarporID(id); // Trae los datos existentes
            model.addAttribute("usuario", usuario); // Se pasan a la vista
            return "usuario_formulario"; 
        }
        @PostMapping("/admin/usuario/editar")
        public String guardarEdicion(@ModelAttribute UsuarioModel usuario) {
            usuarioService.saveUsuario(usuario);
            return "redirect:/admin/usuarios"; // Redirige al listado de usuarios
        }


         // ================= EDITAR =================
    @GetMapping("/editarLiga/{id}")
    public String mostrarFormularioEditarLiga(@PathVariable Long id, Model model) {
        ligasModel liga = ligasService.buscarPorId(id);
        model.addAttribute("liga", liga);
        return "ligaform"; // formulario para editar liga
    }

    @GetMapping("/editarEquipo/{id}")
    public String mostrarFormularioEditarEquipo(@PathVariable Long id, Model model) {
        EquipoModel equipo = equipoService.findbyId(id);
        model.addAttribute("equipo", equipo);
        return "crearEquipo"; // formulario para editar equipo
    }

     // ================= GUARDAR EDICIÓN =================
    @PostMapping("/guardarLiga")
    public String guardarLiga(@ModelAttribute ligasModel liga) {
        ligasService.guardarLiga(liga);
        return "redirect:/dashboard-administrador";
    }

            @PostMapping("/Guardarconfiguracion")
            public String guardarConfiguracion(@ModelAttribute UsuarioModel usuario, HttpSession session, Model model) {
                UsuarioModel usuarioActual = (UsuarioModel) session.getAttribute("usuarioActual");

                if (usuarioActual == null) {
                    return "redirect:/login";
                }

                // Actualizar los campos del usuario actual
                usuarioActual.setNombre(usuario.getNombre());
                usuarioActual.setEmail(usuario.getEmail());
                usuarioActual.setContrasena(usuario.getContrasena());
                usuarioService.saveUsuario(usuarioActual);

                // Actualizar la sesión con el usuario modificado
                session.setAttribute("usuarioActual", usuarioActual);


                model.addAttribute("usuario", usuario);
                
                return "redirect:/configuracion";
            }


    //Eliminarrrr
        @PostMapping("/eliminarLiga/{id}")
    public String eliminarLiga(@PathVariable Long id) {
        ligasService.eliminarLiga(id);
        return "redirect:/dashboard-administrador";
    }

    @PostMapping("/eliminarEquipo/{id}")
    public String eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
        return "redirect:/dashboard-administrador";
    }


    @GetMapping("/crearLiga")
    public String mostrarFormularioCrearLiga(Model model) {
        model.addAttribute("liga", new ligasModel()); // Esto es obligatorio
        return "ligaform";
    }

    @PostMapping("/guardarNuevaLiga")
        public String guardarNuevaLiga(@ModelAttribute ligasModel liga,
                                HttpSession session) {  
        ligasService.guardarLiga(liga);
        return "redirect:/dashboard-administrador";
        }

}
