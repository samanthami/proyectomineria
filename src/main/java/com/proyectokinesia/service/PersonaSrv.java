package com.proyectokinesia.service;


import com.proyectokinesia.dao.PersonaDAO;
import com.proyectokinesia.entidad.Persona;
import com.proyectokinesia.srvImpl.PersonaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaSrv implements PersonaImpl {

    private final PersonaDAO personaDAO;

    public PersonaSrv(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

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
