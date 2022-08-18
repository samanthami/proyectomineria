package com.proyectokinesia.service;

import com.proyectokinesia.dao.EmpresaDao;
import com.proyectokinesia.dao.EntrevistaDao;
import com.proyectokinesia.entidad.Empresa;
import com.proyectokinesia.entidad.Entrevista;
import com.proyectokinesia.service.impl.EntrevistaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EntrevistaSrv  implements EntrevistaImpl {

    @Autowired
    EntrevistaDao dao;

    @Override
    public List<Entrevista> findAll() {
        return dao.findAll();
    }

    @Override
    public Entrevista findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public Entrevista save(Entrevista entrevista) {
        return dao.save(entrevista);
    }

    @Override
    public void update(Entrevista entrevista) {
        dao.save(entrevista);
    }

    @Override
    public List<Entrevista> findByNombreEntrevistador(String nombre) {
        return dao.findByNombreEntrevistador(nombre);
    }

    @Override
    public List<Entrevista> findByFecha(Date fecha) {
        return null;
    }


}
