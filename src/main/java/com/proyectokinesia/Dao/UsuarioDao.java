package com.proyectokinesia.Dao;

import com.proyectokinesia.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioDao  extends JpaRepository<Usuario, String> {
    <S extends Usuario> S findById(Integer id);

    Boolean existsByUsuario(String usuario);


    Usuario findByUsuario(String usuario);
}
