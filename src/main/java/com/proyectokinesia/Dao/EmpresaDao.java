package com.proyectokinesia.Dao;

import com.proyectokinesia.Entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaDao extends JpaRepository<Empresa,String> {

    List<Empresa>findAll();

    Empresa findByNombreEmpresa(String nombreEmpresa);

    @Override
    <S extends Empresa> S save(S entity);


    Empresa findById(Integer id);
}
