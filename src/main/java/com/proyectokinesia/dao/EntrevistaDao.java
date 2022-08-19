package com.proyectokinesia.dao;

import com.proyectokinesia.entidad.Entrevista;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface EntrevistaDao extends JpaRepository<Entrevista, String> {

    @Override
    <S extends Entrevista> List<S> findAll(Example<S> example);

    @Override
    <S extends Entrevista> S save(S entity) ;


    Entrevista findById(Integer id) ;
    List<Entrevista> findByNombreEntrevistador(String nombre);

    List<Entrevista> findByFechaentrevista(Date fecha);
}
