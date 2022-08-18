package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Persona;
import com.proyectokinesia.service.PersonaSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaCtrl {

    @Autowired
   private PersonaSrv personasrv;


    @GetMapping(value = "/personaLista", produces = "application/json")
    public List<Persona> findAll() {
        return personasrv.findAll();
    }

    @GetMapping(value = "/personaByCed/{cedula}")
    public List<Persona> findByCed(@PathVariable("cedula")String cedula){
    return personasrv.findCedula(cedula);
    }

    @PostMapping(value = "/insertPersona")
    public Persona insertpersona(@RequestBody  Persona persona){
        return personasrv.save(persona);
    }

    @PutMapping(value = "/updatePersona/{id}")
    public void updatePersona(@PathVariable("id") Integer id, @RequestBody Persona persona){
        Persona per1 = personasrv.findById(id);
        per1.setNombre(persona.getNombre());
        per1.setApellido(persona.getApellido());
        per1.setTelefono(persona.getTelefono());
        per1.setCedula(persona.getCedula());
        personasrv.save(per1);
    }

}