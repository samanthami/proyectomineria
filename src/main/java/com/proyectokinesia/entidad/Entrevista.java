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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identrevista", nullable = false)
    private Integer id;
    @Column(name = "fechaentrevista")
   private Date fechaentrevista;

    @Column(name = "nombreentrevistador")
    private String nombreEntrevistador;

    private String gestos;



    @ManyToOne
    @JoinColumn(name = "persona_idpersona")
    public Persona personaIdpersona;


    public String getNombreEntrevistador() {
        return nombreEntrevistador;
    }

    public void setNombreEntrevistador(String nombreEntrevistador) {
        this.nombreEntrevistador = nombreEntrevistador;
    }
    @Column(name = "gestos")
    public String getGestos() {
        return gestos;
    }

    public void setGestos(String gestos) {
        this.gestos = gestos;
    }


    public Persona getPersonaIdoersona() {
        return personaIdpersona;
    }

    public void setPersonaIdoersona(Persona personaIdoersona) {
        this.personaIdpersona = personaIdoersona;
    }



    public Date getFechaEntrevista() {
        return fechaentrevista;
    }
    public void setFechaEntrevista(Date fechaEntrevista) {
        this.fechaentrevista = fechaEntrevista;
    }

    public Persona getPersonaIdpersona() {
        return personaIdpersona;
    }

    public void setPersonaIdpersona(Persona personaIdpersona) {
        this.personaIdpersona = personaIdpersona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}