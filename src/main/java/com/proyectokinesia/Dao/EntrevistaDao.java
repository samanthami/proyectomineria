package com.proyectokinesia.Dao;

import com.proyectokinesia.Entity.Entrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrevistaDao extends JpaRepository<Entrevista, Integer> {


    @Query(value = "select e from Persona p, Entrevista e where p.cedula =?1")
    List<Entrevista> findByCedulaEntrevistador(String nombre);

    @Query(value = "select e from Persona p, Entrevista e, Empresa em where em.nombreEmpresa =?1 and p.id = e.personaIdpersona.id and em.id = p.empresa.id ")
    List<Entrevista> allentrevista(String nombre);

}
