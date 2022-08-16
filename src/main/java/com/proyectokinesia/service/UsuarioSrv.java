package com.proyectokinesia.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectokinesia.dao.UsuarioDao;
import com.proyectokinesia.entidad.Usuario;
import com.proyectokinesia.service.impl.UsuarioImpl;

import java.util.List;

@Service
public class UsuarioSrv implements UsuarioImpl {

    @Autowired
    UsuarioDao dao;
    @Autowired
    Personasrv personasrv;


    @Override
    public List<Usuario> find() {
        return  dao.findAll();
    }

    @Override
    public Usuario findById(Integer Id) {
        return null;
    }

    @Override
    public Usuario save(Usuario usuario) {
        usuario.getPersonaIdpersona();

        System.out.println( usuario.getPersonaIdpersona());

        return dao.save(usuario);

    }

    @Override
    public Usuario update(Usuario usuario) {
        return null;
    }
}
