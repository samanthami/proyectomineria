package com.proyectokinesia.dao;

import com.proyectokinesia.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UsuarioDao  extends JpaRepository<Usuario, String> {

    @Override
    <S extends Usuario> S save(S entity);


    <S extends Usuario> S findById(Integer id);



}
