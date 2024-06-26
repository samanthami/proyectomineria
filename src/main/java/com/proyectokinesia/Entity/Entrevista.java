package com.proyectokinesia.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;


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

    @Column(name = "cedulaPsicologo")
    private String cedulaPsicologo;

    private String gestos;


    @JsonIgnoreProperties
    @ManyToOne(fetch = FetchType.EAGER)
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

    public String getCedulaPsicologo() {
        return cedulaPsicologo;
    }

    public void setCedulaPsicologo(String cedulaPsicologo) {
        this.cedulaPsicologo = cedulaPsicologo;
    }
}