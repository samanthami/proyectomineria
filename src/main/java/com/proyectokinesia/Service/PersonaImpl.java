package com.proyectokinesia.Service;

import com.proyectokinesia.Entity.Persona;
import com.proyectokinesia.Entity.Usuario;
import com.proyectokinesia.Exception.CustomException;

import java.util.List;


public interface PersonaImpl {
    List<Persona> findAll();
    Persona findCedula(String cedula);
    Persona findById(Integer Id);
    Persona findByUsuario(Usuario us);
    Persona saveP (Persona persona, Integer id, Integer idRol) throws CustomException;
    Persona save(Persona persona);
    void update(Persona persona);

}
