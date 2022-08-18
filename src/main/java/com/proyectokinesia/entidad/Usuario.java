package com.proyectokinesia.entidad;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario", nullable = false)
    private Integer id;

    private String usuario;

    private String contrasena;

    private Boolean estado = false;


   /* @OneToMany(mappedBy = "usuario")
    public Set<Persona> personas;*/

  /*  public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }*/

    @Column(name = "estado", nullable = false)
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Column(name = "contrasena", nullable = false, length = 45)
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Column(name = "usuario", nullable = false, length = 45)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}