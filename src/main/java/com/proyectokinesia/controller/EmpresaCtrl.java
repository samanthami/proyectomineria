package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Empresa;
import com.proyectokinesia.entidad.Usuario;
import com.proyectokinesia.service.EmpresaSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaCtrl {

    @Autowired
    private EmpresaSrv empresaSrv;


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
