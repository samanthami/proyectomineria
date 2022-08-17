package com.proyectokinesia.service.impl;

import com.proyectokinesia.entidad.Persona;

import java.util.List;

public interface PersonaImpl {

    List<Persona> findAll();
    List<Persona> findCedula(String cedula);
    Persona findById(Integer Id);
    Persona save(Persona persona);
    void update(Persona persona);


}
