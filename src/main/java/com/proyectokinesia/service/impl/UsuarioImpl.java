package com.proyectokinesia.service.impl;

import com.proyectokinesia.entidad.Usuario;

import java.util.List;


public interface UsuarioImpl {
    List<Usuario> find();

    Usuario findById(Integer Id);

    Usuario save(Usuario usuario);

    void update(Usuario usuario);


}
