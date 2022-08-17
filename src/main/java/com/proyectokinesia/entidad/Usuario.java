package com.proyectokinesia.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(as = Usuario.class)
public class Usuario implements Serializable {

    @Id
    @Column(name = "idusuario", nullable = false)
    private Integer id;

    @Column(name = "usuario", nullable = false, length = 45)
    private String usuario;

    @Column(name = "contrasena", nullable = false, length = 45)
    private String contrasena;

    @Column(name = "estado", nullable = false)
    private Integer estado;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_idpersona", nullable = false)
    private Persona personaIdpersona;

    public Persona getPersonaIdpersona() {
        return personaIdpersona;
    }

    public void setPersonaIdpersona(Persona personaIdpersona) {
        this.personaIdpersona = personaIdpersona;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

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