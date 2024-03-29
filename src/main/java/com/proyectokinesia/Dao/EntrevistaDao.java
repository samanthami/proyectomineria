package com.proyectokinesia.Dao;

import com.proyectokinesia.Entity.Entrevista;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EntrevistaDao extends JpaRepository<Entrevista, String> {
    @Override
    <S extends Entrevista> List<S> findAll(Example<S> example);

    @Override
    <S extends Entrevista> S save(S entity) ;


    Entrevista findById(Integer id) ;
    List<Entrevista> findByNombreEntrevistador(String nombre);


    @Query(value = "select e from Persona p, Entrevista e, Empresa em where em.nombreempresa =?1 and p.id = e.personaIdpersona.id and em.id = p.empresa.id ")
    List<Entrevista> allentrevista(String nombre);
}
