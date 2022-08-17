package com.proyectokinesia.entidad;

import javax.persistence.*;

@Entity
@Table(name = "entrevista")
public class Entrevista {
    @Id
    @Column(name = "identrevista", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_idpersona")
    private Persona personaIdpersona;

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

    //TODO Reverse Engineering! Migrate other columns to the entity
}