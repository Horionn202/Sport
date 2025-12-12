package com.example.Sport.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "equipos")
public class EquipoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String Deporte;
    private String ciudad;
    private Integer fechaFundacion;
    private String nombreEntrenador;
    private Integer cantJugadores;
    private String descripcion;
    private Integer partidosGanados = 0;
    private Integer partidosPerdidos = 0;

    // Getters y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String deporte) {
        Deporte = deporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Integer fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public Integer getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(Integer cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPartidosGanados() {
        return partidosGanados;
    }
    public void setPartidosGanados(Integer partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public Integer getPartidosPerdidos() {
        return partidosPerdidos;
    }
    public void setPartidosPerdidos(Integer partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }


}
