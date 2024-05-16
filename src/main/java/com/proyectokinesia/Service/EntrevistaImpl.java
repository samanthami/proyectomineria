package com.proyectokinesia.Service;

import com.proyectokinesia.Entity.Entrevista;

import java.util.Date;
import java.util.List;


public interface EntrevistaImpl {

    List<Entrevista> findAll();
    Entrevista findById(Integer id);
    Entrevista save (Entrevista entrevista);
    void update(Entrevista entrevista);

    List<Entrevista> findByCedulaEntrevistador(String nombre);
    List<Entrevista> findByFecha(Date fecha);
}
