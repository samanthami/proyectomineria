package com.proyectokinesia.service;


import com.proyectokinesia.entidad.Usuario;
import com.proyectokinesia.srvImpl.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectokinesia.dao.UsuarioDao;

import java.util.List;

@Service
public class UsuarioSrv implements UsuarioImpl {

    private final UsuarioDao dao;

    public UsuarioSrv(UsuarioDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Usuario> find() {
        return dao.findAll();
    }

    @Override
    public  Usuario findById(Integer Id) {
        return dao.findById(Id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return dao.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
         dao.save(usuario);
    }


    public Usuario estado(Integer Id) {
        Usuario usr = dao.findById(Id);
        if (usr.getEstado() == true){
            usr.setEstado(false);
        }else{
            usr.setEstado(true);
        }
        return dao.save(usr);
    }
}
