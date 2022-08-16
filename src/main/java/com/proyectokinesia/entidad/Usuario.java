package com.proyectokinesia.entidad;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class Usuario implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario", nullable = false)
    private Integer id;

    @Column(name = "usuario", nullable = false, length = 45)
    private String usuario;

    @Column(name = "contrasena", nullable = false, length = 45)
    private String contrasena;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona_idpersona", nullable = false)
    public Persona personaIdpersona;

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