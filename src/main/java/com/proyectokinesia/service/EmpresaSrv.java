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
    public Empresa findById(Integer id) {
        return  empresaDao.findById(id);
    }

    @Override
    public Empresa findByNombreEmpresa(String nombre) {
        return empresaDao.findByNombreempresa(nombre);
    }

    @Override
    public Empresa save(Empresa empresa) {
        return empresaDao.save(empresa);
    }

    @Override
    public void update(Empresa empresa) {
        empresaDao.save(empresa);
    }

    public Empresa estado(Integer id){
        Empresa em = empresaDao.findById(id);
        if (em.getEstado() == true){
            em.setEstado(false);
        }else {
            em.setEstado(true);
        }
        return empresaDao.save(em);
    }
}
