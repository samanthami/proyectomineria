package com.proyectokinesia.controller;


import com.proyectokinesia.Entity.Usuario;
import com.proyectokinesia.Service.UsuarioSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioCtrl {

   private final UsuarioSrv usuarioSrv;

    public UsuarioCtrl(UsuarioSrv usuarioSrv) {
        this.usuarioSrv = usuarioSrv;
    }

    @GetMapping(value = "/usuario")
    public List<Usuario> findAll(){
        return usuarioSrv.find();
    }

    @GetMapping(value = "/usuarioById/{id}")
    public Usuario findAll(@PathVariable("id") Integer id){
        return  usuarioSrv.findById(id);
    }

    @PostMapping(value = "/inseruser",consumes = { "application/json" })
    public Usuario insertusuario(@RequestBody Usuario usuario, String rolUsuario) throws Exception {
        return usuarioSrv.save(usuario, rolUsuario);
    }

    @PutMapping(value = "/updateUsuario/{id}")
    public void updateUsuario(@PathVariable("id")Integer id, @RequestBody Usuario usuario){

       Usuario user = usuarioSrv.findById(id);

       user.setContrasena(usuario.getContrasena());
       user.setUsuario(usuario.getUsuario());
       usuarioSrv.update(user);

    }

    @PutMapping(value = "/desactivarUsuario/{id}")
    public Usuario desactivar(@PathVariable("id")Integer id){
        return usuarioSrv.estado(id);
    }
}
