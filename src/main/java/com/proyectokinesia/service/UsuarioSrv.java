package com.proyectokinesia.service;


import com.proyectokinesia.entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectokinesia.dao.UsuarioDao;
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
        return dao.findAll();
    }

    @Override
    public Usuario findById(Integer Id) {
        return dao.findById(Id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return dao.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return dao.save(usuario);
    }


    public Usuario estado(Integer Id) {
        Usuario usr = dao.findById(Id);
        if (usr.getEstado() == 1){
            usr.setEstado(0);
        }else{
            usr.setEstado(1);
        }
        return dao.save(usr);
    }
}
