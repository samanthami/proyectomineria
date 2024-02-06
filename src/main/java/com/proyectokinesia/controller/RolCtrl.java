package com.proyectokinesia.controller;

import com.proyectokinesia.Entity.Rol;
import com.proyectokinesia.Service.RolSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RolCtrl {

    private final RolSrv rolSrv;

    public RolCtrl(RolSrv rolSrv) {
        this.rolSrv = rolSrv;
    }

    @GetMapping(value = "/rol")
    public List<Rol> findAll(){
        return rolSrv.findAll();
    }

    @PostMapping(value = "/rol-create")
    public Rol create(Rol rol){
        return rolSrv.save(rol);
    }

    @GetMapping(value = "/rol/{id}")
    public Optional<Rol> findById(@PathVariable("id") Integer id){
        return rolSrv.findById(id);
    }
}
