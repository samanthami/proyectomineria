package com.proyectokinesia.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;




@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresas", nullable = false)
    private Integer id;

    private String nombreempresa;

    private String telefono;

    private Boolean estado = false;

    
   /* @OneToMany(mappedBy = "empresa")
    public Set<Persona> personas;*/

    /*public Set<Persona> getPersonas() {
        return personas;
    }*/
    @Column(name = "nombreempresa", nullable = false)
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
    @Column(name = "estado", nullable = false)
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