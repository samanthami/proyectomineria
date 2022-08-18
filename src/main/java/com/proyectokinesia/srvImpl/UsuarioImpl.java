package com.proyectokinesia.srvImpl;

import com.proyectokinesia.entidad.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioImpl {
    List<Usuario> find();

    Usuario findById(Integer Id);

    Usuario save(Usuario usuario);

    void update(Usuario usuario);


}
