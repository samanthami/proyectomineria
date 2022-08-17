package com.proyectokinesia.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @Column(name = "idpersona", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", length = 45)
    private String apellido;

    @Column(name = "telefono", length = 45)
    private String telefono;

    @Column(name = "rol", nullable = false, length = 45)
    private String rol;

    @Column(name = "cedula", nullable = false, length = 45)
    private String cedula;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "personaIdpersona")
    private Usuario usuarios;

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}