package com.proyectokinesia.dao;

import com.proyectokinesia.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioDao  extends JpaRepository<Usuario, String> {

    @Query(value = "SELECT * FROM Usuario ", nativeQuery = true)
    List<Usuario> findAll();

    @Override
    <S extends Usuario> S save(S entity);


    <S extends Usuario> S findById(Integer id);
}
