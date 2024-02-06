package com.proyectokinesia.controller;

import com.proyectokinesia.Entity.Persona;
import com.proyectokinesia.Service.PersonaSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaCtrl {

   private final PersonaSrv personasrv;

    public PersonaCtrl(PersonaSrv personasrv) {
        this.personasrv = personasrv;
    }

    @GetMapping(value = "/personaLista", produces = "application/json")
    public List<Persona> findAll() {
        return personasrv.findAll();
    }

    @GetMapping(value = "/personaByCed/{cedula}")
    public Persona findByCed(@PathVariable("cedula")String cedula){
        return personasrv.findCedula(cedula);
    }

    @PostMapping(value = "/insertPersona/{id}/{idRol}")
    public Persona insertpersona(@RequestBody  Persona persona, @PathVariable("id")Integer id, @PathVariable("idRol")Integer idRol){
        return personasrv.saveP(persona, id, idRol);
    }

    @PostMapping(value = "/inPerNam/{em}")
    public  Persona insertPe(@RequestBody Persona persona, @PathVariable("em")String em){
        return personasrv.saveNamePer(persona,em);
    }

    @PutMapping(value = "/updatePersona/{id}")
    public void updatePersona(@PathVariable("id") Integer id, @RequestBody Persona persona){
        Persona per1 = personasrv.findById(id);
        per1.setNombre(persona.getNombre());
        per1.setApellido(persona.getApellido());
        per1.setTelefono(persona.getTelefono());
        per1.setCedula(persona.getCedula());
        per1.setCorreo(persona.getCorreo());
        per1.setGenero(persona.getGenero());
        personasrv.save(per1);
    }

    @GetMapping(value = "/personaRlEm/{rol}/{Em}")
    public List<Persona> findRolEmpres(@PathVariable("rol") String rol, @PathVariable("Em")String empresa){
        return personasrv.finbyRolEmpresa(rol, empresa);
    }

}