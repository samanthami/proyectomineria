package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Persona;
import com.proyectokinesia.service.Personasrv;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaCtrl {

   Personasrv personasrv;

    public PersonaCtrl(Personasrv personasrv) {
        this.personasrv = personasrv;
    }

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
    public Persona updatePersona(@PathVariable("id")Integer id, @RequestBody Persona persona){
        Persona per1 = personasrv.findById(id);
        return personasrv.save(per1);
    }
    @GetMapping(value = "/", produces = "application/json")
    public List<Persona> findAll1() {
        return personasrv.findAll();
    }
}