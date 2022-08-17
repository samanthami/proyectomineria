package com.proyectokinesia.dao;

import com.proyectokinesia.entidad.Empresa;
import com.proyectokinesia.entidad.Persona;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaDao extends JpaRepository<Empresa,String> {

    List<Empresa>findAll();

    Empresa findByNombreempresa(String nombreEmpresa);

    @Override
    <S extends Empresa> S save(S entity);

    <S extends Empresa> S findById(Integer id);

}
