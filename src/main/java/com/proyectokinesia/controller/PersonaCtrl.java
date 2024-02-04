package com.proyectokinesia.controller;

import com.proyectokinesia.Entity.Persona;
import com.proyectokinesia.Service.PersonaSrv;
import com.proyectokinesia.Service.UsuarioSrv;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaCtrl {

   private final PersonaSrv personasrv;
   private final UsuarioSrv usuarioSrv;

    public PersonaCtrl(PersonaSrv personasrv, UsuarioSrv usuarioSrv) {
        this.personasrv = personasrv;
        this.usuarioSrv = usuarioSrv;
    }

    @GetMapping(value = "/personaLista", produces = "application/json")
    public List<Persona> findAll() {
        return personasrv.findAll();
    }

    @GetMapping(value = "/personaByCed/{cedula}")
    public Persona findByCed(@PathVariable("cedula")String cedula){
        return personasrv.findCedula(cedula);
    }

    @PostMapping(value = "/insertPersona/{id}")
    public Persona insertpersona(@RequestBody  Persona persona, @PathVariable("id")Integer id){
        return personasrv.saveP(persona, id);
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
/*
    @GetMapping(value = "/personaRol/{rol}")
    public List<Persona> findRol(@PathVariable("rol") String rol){
        return personasrv.finbyRol(rol);
    }*/

    @GetMapping(value = "/personaRlEm/{rol}/{Em}")
    public List<Persona> findRolEmpres(@PathVariable("rol") String rol, @PathVariable("Em")String Em){
        return personasrv.finbyRolEmpresa(rol, Em);
    }

}