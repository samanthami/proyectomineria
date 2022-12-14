package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Entrevista;
import com.proyectokinesia.service.EntrevistaSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EntrevistaCtrl {

    @Autowired
    private EntrevistaSrv entrevistaSrv;

    @GetMapping(value = "/entrevista")
    public List<Entrevista> findAll(){
        return entrevistaSrv.findAll();
    }

    @PostMapping(value = "/entrevistain")
    public Entrevista entrevistain(@RequestBody Entrevista entrevista){
        return entrevistaSrv.save(entrevista);
    }

    @GetMapping(value = "/entrevistaLi/{nombre}")
    public List<Entrevista> findEntrevistador(@PathVariable("nombre") String nombre){
        return entrevistaSrv.findByNombreEntrevistador(nombre);
    }



}
