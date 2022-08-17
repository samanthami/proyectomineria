package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Empresa;
import com.proyectokinesia.service.EmpresaSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpresaCtrl {

    EmpresaSrv empresaSrv;

    public EmpresaCtrl(EmpresaSrv empresaSrv) {
        this.empresaSrv = empresaSrv;
    }

    @GetMapping(value = "/empresa")
    public List<Empresa> findAll(){
        return empresaSrv.findAll();
    }
}
