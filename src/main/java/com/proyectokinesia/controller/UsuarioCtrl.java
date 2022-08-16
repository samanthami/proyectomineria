package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Persona;
import com.proyectokinesia.entidad.Usuario;
import com.proyectokinesia.service.UsuarioSrv;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/updateUsuario/{id}")
    public Usuario updateUsuario(@PathVariable("id")Integer id, @RequestBody Usuario usuario){
        Usuario user = usuarioSrv.findById(id);
        return usuarioSrv.save(user);
    }
}
