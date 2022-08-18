package com.proyectokinesia.service.impl;

import com.proyectokinesia.entidad.Entrevista;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface EntrevistaImpl {

    List<Entrevista> findAll();
    Entrevista findById(Integer id);
    Entrevista save (Entrevista entrevista);
    void update(Entrevista entrevista);

    List<Entrevista> findByNombreEntrevistador(String nombre);
    List<Entrevista> findByFecha(Date fecha);
}
