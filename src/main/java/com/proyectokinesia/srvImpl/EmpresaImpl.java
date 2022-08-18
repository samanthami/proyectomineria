package com.proyectokinesia.srvImpl;

import com.proyectokinesia.entidad.Empresa;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmpresaImpl {

    List<Empresa> findAll();
    Empresa findById(Integer id);
    Empresa findByNombreEmpresa(String nombre);
    Empresa save(Empresa empresa);
    void update(Empresa empresa);
}
