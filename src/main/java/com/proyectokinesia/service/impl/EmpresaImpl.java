package com.proyectokinesia.service.impl;

import com.proyectokinesia.entidad.Empresa;
import com.proyectokinesia.entidad.Persona;

import java.util.List;

public interface EmpresaImpl {

    List<Empresa> findAll();
    Empresa findByNombreEmpresa(String nombre);
    Empresa save(Empresa empresa);
    void update(Empresa empresa);
}
