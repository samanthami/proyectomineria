package com.proyectokinesia.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", length = 45)
    private String apellido;

    @Column(name = "genero", nullable = false, length = 45)
    private String genero;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "telefono", length = 45)
    private String telefono;

    @Column(name = "cedula", nullable = false, length = 45)
    private String cedula;


    @OneToOne
    @JoinColumn(name = "usuario_idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "empresa_idempresas")
    private Empresa empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "personaIdpersona")
    private Set<Entrevista> entrevistas = new LinkedHashSet<>();

    public void setEntrevistas(Set<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}