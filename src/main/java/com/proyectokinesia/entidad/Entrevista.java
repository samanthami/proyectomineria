package com.proyectokinesia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrevista")
public class Entrevista  {

    @Id
    @Column(name = "identrevista", nullable = false)
    private Integer id;

   // private Date fechaEntrevista;
    @Column(name = "nombreentrevistador")
    private String nombreEntrevistador;
    @Column(name = "gestos")
    private String gestos;
    @Column(name = "entrevistacol")
    private String entrevistacol;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona_idpersona", nullable = false)
    public Persona personaIdoersona;


    public String getNombreEntrevistador() {
        return nombreEntrevistador;
    }

    public void setNombreEntrevistador(String nombreEntrevistador) {
        this.nombreEntrevistador = nombreEntrevistador;
    }

    public String getGestos() {
        return gestos;
    }

    public void setGestos(String gestos) {
        this.gestos = gestos;
    }

    public String getEntrevistacol() {
        return entrevistacol;
    }

    public void setEntrevistacol(String entrevistacol) {
        this.entrevistacol = entrevistacol;
    }



    public Persona getPersonaIdoersona() {
        return personaIdoersona;
    }

    public void setPersonaIdoersona(Persona personaIdoersona) {
        this.personaIdoersona = personaIdoersona;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}