package com.example.Sport.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String usuario;
    private String apellido;
    private String email;
    private String experiencia;
    private String ciudad;
    private String partidos;
    private String goles;
    private String asistencias;
    private String equipo;
    private String contrasena;
    private LocalDate fechaNacimiento;
    private String posicion;
    private String rol;

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario(){
        return usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getRol() {
        return rol;
    }

    public String getCiudad() {
        return ciudad;
    }
    public String getPartidos() {
        return partidos;
    }
    public String getGoles() {
        return goles;
    }
    public String getAsistencias() {
        return asistencias;
    }
    public String getEquipo() {
        return equipo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public String getPosicion() {
        return posicion;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {   // ← ESTE ES EL QUE TE FALTABA
        this.nombre = nombre;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setPartidos(String partidos) {
        this.partidos = partidos;
    }
    public void setGoles(String goles) {
        this.goles = goles;
    }
    public void setAsistencias(String asistencias) {
        this.asistencias = asistencias;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

}
