package com.proyectokinesia.dao;


import com.proyectokinesia.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaDAO extends JpaRepository<Persona, String> {
    List<Persona> findAll();

    List<Persona> findByCedula(String cedula);

    @Override
    <S extends Persona> S save(S entity);

    <S extends Persona> S findById(Integer id);
}
