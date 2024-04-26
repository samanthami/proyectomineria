package com.proyectokinesia.Service;

import com.proyectokinesia.Entity.Empresa;

import java.util.List;

public interface EmpresaImpl {
    List<Empresa> findAll();
    Empresa findById(Integer id);
    Empresa findByNombreEmpresa(String nombre);
    Empresa save(Empresa empresa) throws Exception;
    void update(Empresa empresa);
}
