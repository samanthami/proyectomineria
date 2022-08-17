package com.proyectokinesia.service;

import com.proyectokinesia.dao.EmpresaDao;
import com.proyectokinesia.entidad.Empresa;
import com.proyectokinesia.service.impl.EmpresaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaSrv implements EmpresaImpl {

    @Autowired
    EmpresaDao empresaDao;
    @Override
    public List<Empresa> findAll() {
        return empresaDao.findAll();
    }

    @Override
    public Empresa findByNombreEmpresa(String nombre) {
        return null;
    }

    @Override
    public Empresa save(Empresa empresa) {
        return null;
    }

    @Override
    public void update(Empresa empresa) {

    }
}
