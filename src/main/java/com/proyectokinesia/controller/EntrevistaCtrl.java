package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Entrevista;
import com.proyectokinesia.service.EntrevistaSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrevistaCtrl {

    EntrevistaSrv entrevistaSrv;

    public EntrevistaCtrl(EntrevistaSrv entrevistaSrv) {
        this.entrevistaSrv = entrevistaSrv;
    }

    @GetMapping(value = "/entrevista")
    public List<Entrevista> findAll(){
        return entrevistaSrv.findAll();
    }
}
