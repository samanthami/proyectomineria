package com.proyectokinesia.service;


import com.proyectokinesia.dao.PersonaDAO;
import com.proyectokinesia.entidad.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Personasrv  implements PersonaImpl {

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    public List<Persona> findAll() {
        return personaDAO.findAll();
    }

    @Override
    public List<Persona> findCedula(String cedula) {
        return personaDAO.findByCedula(cedula);
    }

    @Override
    public Persona findById(Integer Id) {
        return personaDAO.findById(Id);
    }


    @Override
    public Persona save(Persona persona) {
        return personaDAO.save(persona);
    }



    @Override
    public void update(Persona persona) {
       personaDAO.save(persona);
    }


}
