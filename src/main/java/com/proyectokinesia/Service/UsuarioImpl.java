package com.proyectokinesia.Service;

import com.proyectokinesia.Entity.Usuario;

import java.util.List;
import java.util.Optional;


public interface UsuarioImpl {
    List<Usuario> find();

    Usuario findById(Integer Id);

    Usuario save(Usuario usuario, String rolUsario) throws Exception;

    void update(Usuario usuario);

    Optional<Usuario> findByUsuario (String usuario);

}
