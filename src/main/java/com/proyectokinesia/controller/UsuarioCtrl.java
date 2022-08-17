package com.proyectokinesia.controller;

import com.proyectokinesia.entidad.Usuario;
import com.proyectokinesia.service.Personasrv;
import com.proyectokinesia.service.UsuarioSrv;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioCtrl {

    UsuarioSrv usuarioSrv;
    Personasrv personasrv;

    public UsuarioCtrl(UsuarioSrv usuarioSrv,Personasrv personasrv) {
        this.usuarioSrv = usuarioSrv;
        this.personasrv = personasrv;
    }

    @GetMapping(value = "/usuario")
    public List<Usuario> findAll(){
        return usuarioSrv.find();
    }

    @PostMapping(value = "/inseruser",consumes = { "application/json" })
    public Usuario insertusuario(@RequestBody Usuario usuario){
        return usuarioSrv.save(usuario);
    }

    @PutMapping(value = "/updateUsuario/{id}")
    public Usuario updateUsuario(@PathVariable("id")Integer id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return usuarioSrv.update(usuario);
    }

    @PutMapping(value = "/desactivarUsuario/{id}")
    public Usuario desactivar(@PathVariable("id")Integer id){
        return usuarioSrv.estado(id);
    }
}
