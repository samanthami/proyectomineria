package com.proyectokinesia.controller;

import com.proyectokinesia.Entity.Empresa;
import com.proyectokinesia.Service.EmpresaSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpresaCtrl {


    private final EmpresaSrv empresaSrv;

    public EmpresaCtrl(EmpresaSrv empresaSrv) {
        this.empresaSrv = empresaSrv;
    }

    @GetMapping(value = "/empresa")
    public List<Empresa> findAll(){
        return empresaSrv.findAll();
    }

    @PostMapping(value = "/empresaIS")
    public Empresa inserempresa(@RequestBody Empresa empresa){
        return empresaSrv.save(empresa);
    }

    @GetMapping(value = "/empresaNM/{name}")
    public Empresa findNombre(@PathVariable("name") String nombre){
        return empresaSrv.findByNombreEmpresa(nombre);
    }

    @PutMapping(value = "/empresaUP/{id}")
    public void updateEm(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
        Empresa em = empresaSrv.findById(id);
        em.setNombreempresa(empresa.getNombreempresa());
       em.setTelefono(empresa.getNombreempresa());
       empresaSrv.save(em);

    }

    @PutMapping(value = "/empresaEs/{id}")
    public Empresa desactivarActivar(@PathVariable("id")Integer id){
        return empresaSrv.estado(id);
    }
}
