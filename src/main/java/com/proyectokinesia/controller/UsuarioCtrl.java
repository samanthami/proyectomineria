package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Usuario;
import com.proyectokinesia.service.UsuarioSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioCtrl {

    UsuarioSrv usuarioSrv;

    public UsuarioCtrl(UsuarioSrv usuarioSrv) {
        this.usuarioSrv = usuarioSrv;
    }

    @GetMapping(value = "/usuario")
    public List<Usuario> findAll(){
        return usuarioSrv.find();
    }

    @PostMapping(value = "/inseruser")
    public Usuario insertusuario(@RequestBody Usuario usuario){
        return usuarioSrv.save(usuario);
    }

}
