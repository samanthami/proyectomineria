package com.proyectokinesia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @Column(name = "idempresas", nullable = false)
    private Integer id;

    private String nombreempresa;

    private String telefono;

    private Boolean estado;

    
   /* @OneToMany(mappedBy = "empresa")
    public Set<Persona> personas;*/

    /*public Set<Persona> getPersonas() {
        return personas;
    }*/
    @Column(name = "nombreempresa")
    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Column(name = "estado")
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /*public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}