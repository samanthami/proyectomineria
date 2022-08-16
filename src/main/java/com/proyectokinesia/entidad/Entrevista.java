package com.proyectokinesia.entidad;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "entrevista")
public class Entrevista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identrevista", nullable = false)
    private Integer id;

    @Column(name = "fechaEntrevista", nullable = false)
    private LocalDate fechaEntrevista;

    @Column(name = "gestos", nullable = false, length = 100)
    private String gestos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona_idpersona", nullable = false)
    private Persona personaIdpersona;

    public Persona getPersonaIdpersona() {
        return personaIdpersona;
    }

    public void setPersonaIdpersona(Persona personaIdpersona) {
        this.personaIdpersona = personaIdpersona;
    }

    public String getGestos() {
        return gestos;
    }

    public void setGestos(String gestos) {
        this.gestos = gestos;
    }

    public LocalDate getFechaEntrevista() {
        return fechaEntrevista;
    }

    public void setFechaEntrevista(LocalDate fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}